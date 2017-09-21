package com.sunzn.utils.library;

import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by sunzn on 2017/9/21.
 */

public class JsonUtils {

    private JsonUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取 JSON 的第一个 KEY
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：object  JSON对象
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：第一个KEY
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getFirstKey(JSONObject object) {
        if (object != null) {
            Iterator<String> iterator = object.keys();
            if (iterator.hasNext()) {
                return iterator.next();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
