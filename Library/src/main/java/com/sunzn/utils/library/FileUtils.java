package com.sunzn.utils.library;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static android.content.ContentValues.TAG;

public class FileUtils {

    private FileUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取文件扩展名
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：file
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：String
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getExtensionName(File file) {
        if (file != null && file.exists()) {
            String fileName = file.getName();
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return StringUtils.NULL;
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：保存图片到相册
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：bmp      位图
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String saveImageToGallery(Context context, Bitmap bmp) {
        return saveImageToGallery(context, "DCIM", bmp);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：保存图片到相册
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：child    子目录
     * ║ 参数：bmp      位图
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String saveImageToGallery(Context context, String child, Bitmap bmp) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            String fileName = System.currentTimeMillis() + ".jpg";
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.DISPLAY_NAME, fileName);
            values.put(MediaStore.Images.Media.DESCRIPTION, "");
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
            values.put(MediaStore.Images.Media.IS_PENDING, 1);
            values.put(MediaStore.Images.Media.RELATIVE_PATH, "DCIM/Dian/");
            Uri url = null;
            String stringUrl = null;    /* value to be returned */
            ContentResolver resolver = context.getContentResolver();
            try {
                Uri uri = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
                url = resolver.insert(uri, values);
                if (url == null) {
                    return null;
                }
                ParcelFileDescriptor parcelFileDescriptor = resolver.openFileDescriptor(url, "w");
                FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                bmp.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();

                values.clear();
                values.put(MediaStore.Images.Media.IS_PENDING, 0);
                resolver.update(uri, values, null, null);

                ToastUtils.success(context, "保存成功");
            } catch (Exception e) {
                Log.e(TAG, "Failed to insert media file", e);
                if (url != null) {
                    resolver.delete(url, null, null);
                    url = null;
                }
                ToastUtils.failure(context, "保存失败");
            }
            if (url != null) {
                stringUrl = url.toString();
            }
            return stringUrl;
        } else {
            // 首先保存图片
            File appDir = new File(Environment.getExternalStorageDirectory(), child);
            if (!appDir.exists()) {
                appDir.mkdir();
            }
            String fileName = System.currentTimeMillis() + ".jpg";
            File file = new File(appDir, fileName);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 其次把文件插入到系统图库
            try {
                MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);
                ToastUtils.success(context, "保存成功");
            } catch (FileNotFoundException e) {
                ToastUtils.failure(context, "保存失败");
                e.printStackTrace();
            }
            // 最后通知图库更新
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(appDir.getPath()))));

            return file.getAbsolutePath();
        }
    }

}
