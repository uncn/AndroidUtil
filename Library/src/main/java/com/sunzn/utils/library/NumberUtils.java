package com.sunzn.utils.library;

import java.util.Random;

/**
 * Created by sunzn on 2016/12/7.
 */

public class NumberUtils {

    private NumberUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：在一个区间内产生随机整数数
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：min、max
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：区间随机整数
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}
