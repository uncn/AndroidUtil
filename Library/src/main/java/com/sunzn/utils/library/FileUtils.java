package com.sunzn.utils.library;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
