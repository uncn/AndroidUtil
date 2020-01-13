package com.sunzn.utils.library;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.annotation.NonNull;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sunzn on 2017/5/2.
 */

public class AssetUtils {

    private AssetUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：读取 Asserts 目录下的文件
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：fileName    文件名
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：文件 String 值
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String readAssertsFile(@NonNull Context context, @NonNull String fileName) {
        byte[] file = getAssertsFile(context, fileName);
        return file == null ? null : new String(file);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 Asserts 目录下的文件
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：fileName    文件名
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：文件字节数组
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static byte[] getAssertsFile(@NonNull Context context, @NonNull String fileName) {
        InputStream inputStream = null;
        AssetManager assetManager = context.getAssets();
        try {
            inputStream = assetManager.open(fileName);

            BufferedInputStream bis = null;
            int length;
            try {
                bis = new BufferedInputStream(inputStream);
                length = bis.available();
                byte[] data = new byte[length];
                bis.read(data);
                return data;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
