package com.sunzn.utils.library;

import java.io.File;

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

}
