package com.sunzn.utils.library;

import android.content.Context;
import android.content.res.AssetManager;

import org.apache.commons.io.FileUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DBUtils {

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：释放 Assets 目录下的 ZIP 数据库文件到数据库目录
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context  上下文
     * ║ 参数：source   Assets 目录下的 zip 数据库文件名
     * ║ 参数：target   Database 目录下释放的 db 数据库文件名
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void release(Context context, String source, String target) {
        if (context != null && source != null && target != null) {
            File GoalDB = context.getDatabasePath(target);
            if (!GoalDB.exists()) {
                copyFile(context, source);
            }
        }
    }

    private static void copyFile(Context context, String source) {
        File target = context.getDatabasePath(source);
        try {
            AssetManager manager = context.getAssets();
            InputStream stream = manager.open(source);
            FileUtils.copyInputStreamToFile(stream, target);
            UZipFile(target.getAbsolutePath(), target.getParent() + "/");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileUtils.deleteQuietly(target);
        }
    }

    private static void UZipFile(String zipFile, String targetDir) {
        int BUFFER = 4096;
        String strEntry;
        try {
            BufferedOutputStream dest;
            FileInputStream fis = new FileInputStream(zipFile);
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                try {
                    int count;
                    byte[] data = new byte[BUFFER];
                    strEntry = entry.getName();

                    File entryFile = new File(targetDir + strEntry);
                    File entryDir = new File(entryFile.getParent());
                    if (!entryDir.exists()) {
                        entryDir.mkdirs();
                    }
                    FileOutputStream fos = new FileOutputStream(entryFile);
                    dest = new BufferedOutputStream(fos, BUFFER);
                    while ((count = zis.read(data, 0, BUFFER)) != -1) {
                        dest.write(data, 0, count);
                    }
                    dest.flush();
                    dest.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            zis.close();
        } catch (Exception cwj) {
            cwj.printStackTrace();
        }
    }

}
