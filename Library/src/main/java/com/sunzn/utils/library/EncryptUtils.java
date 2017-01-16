package com.sunzn.utils.library;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {

    private EncryptUtils() {
        throw new RuntimeException("Stub!");
    }

    private enum MD5Type {
        BIT16, BIT32;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：执行 16 位 MD5 加密
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：source  明文字符串
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：16 位密文
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String E16(String source) {
        return MD5(source, MD5Type.BIT16);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：执行 32 位 MD5 加密
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：source  明文字符串
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：32 位密文
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String E32(String source) {
        return MD5(source, MD5Type.BIT32);
    }


    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：执MD5 加密
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：source  明文字符串
     * ║ 参数：type    加密类型
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：对应类型加密密文
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    private static String MD5(String source, MD5Type type) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuilder buf = new StringBuilder("");
            for (byte aB : b) {
                i = aB;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            switch (type) {
                case BIT16:
                    result = buf.toString().substring(8, 24);
                    break;
                case BIT32:
                    result = buf.toString();
                    break;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

}