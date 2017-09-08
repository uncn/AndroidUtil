package com.sunzn.utils.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by sunzn on 2016/12/7.
 */

public class TimeUtils {

    private TimeUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║                                                备选时间格式
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║                                               HH:mm   15:44
     * ║                                              h:mm a   3:44 下午
     * ║                                             HH:mm z   15:44 CST
     * ║                                             HH:mm Z   15:44 +0800
     * ║                                          HH:mm zzzz   15:44 中国标准时间
     * ║                                            HH:mm:ss   15:44:40
     * ║                                          yyyy-MM-dd   2016-08-12
     * ║                                    yyyy-MM-dd HH:mm   2016-08-12 15:44
     * ║                                 yyyy-MM-dd HH:mm:ss   2016-08-12 15:44:40
     * ║                            yyyy-MM-dd HH:mm:ss zzzz   2016-08-12 15:44:40 中国标准时间
     * ║                       EEEE yyyy-MM-dd HH:mm:ss zzzz   星期五 2016-08-12 15:44:40 中国标准时间
     * ║                            yyyy-MM-dd HH:mm:ss.SSSZ   2016-08-12 15:44:40.461+0800
     * ║                          yyyy-MM-dd'T'HH:mm:ss.SSSZ   2016-08-12T15:44:40.461+0800
     * ║                        yyyy.MM.dd G 'at' HH:mm:ss z   2016.08.12 公元 at 15:44:40 CST
     * ║                                              K:mm a   3:44 下午
     * ║                                    EEE, MMM d, ''yy   星期五, 八月 12, '16
     * ║                               hh 'o''clock' a, zzzz   03 o'clock 下午, 中国标准时间
     * ║                        yyyyy.MMMMM.dd GGG hh:mm aaa   02016.八月.12 公元 03:44 下午
     * ║                          EEE, d MMM yyyy HH:mm:ss Z   星期五, 12 八月 2016 15:44:40 +0800
     * ║                                       yyMMddHHmmssZ   160812154440+0800
     * ║                          yyyy-MM-dd'T'HH:mm:ss.SSSZ   2016-08-12T15:44:40.461+0800
     * ║   EEEE 'DATE('yyyy-MM-dd')' 'TIME('HH:mm:ss')' zzzz   星期五 DATE(2016-08-12) TIME(15:44:40) 中国标准时间
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║             注意：SimpleDateFormat不是线程安全的，线程安全需用{@code ThreadLocal<SimpleDateFormat>}
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final String[] CHINESE_ZODIAC = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取当前毫秒时间戳
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：毫秒时间戳
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static long getCurrentTimeMills() {
        return System.currentTimeMillis();
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取今天起始时间戳
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：毫秒时间戳
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static long getTodayOfStart() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：将时间戳转为时间字符串
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：millis 毫秒时间戳
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 格式：yyyy-MM-dd HH:mm:ss
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：时间字符串
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String millis2String(long millis) {
        return new SimpleDateFormat(DEFAULT_PATTERN, Locale.getDefault()).format(new Date(millis));
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：将时间戳转为时间字符串
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：millis  毫秒时间戳
     * ║ 参数：pattern 时间格式
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：时间字符串
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String millis2String(long millis, String pattern) {
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(new Date(millis));
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：将时间字符串转为时间戳
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：time    时间字符串
     * ║ 参数：pattern 时间格式
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：时间戳
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static long string2Millis(String time, String pattern) throws ParseException {
        return new SimpleDateFormat(pattern, Locale.getDefault()).parse(time).getTime();
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：将 Date 类型转为时间戳
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：date Date 类型时间
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：毫秒时间戳
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static long date2Millis(Date date) {
        return date.getTime();
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：将时间戳转为 Date 类型
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：millis 毫秒时间戳
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：Date 类型时间
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Date millis2Date(long millis) {
        return new Date(millis);
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取生肖
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：year 年
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：生肖
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getChineseZodiac(int year) {
        return CHINESE_ZODIAC[year % 12];
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取生肖
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：millis 毫秒时间戳
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：生肖
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getChineseZodiac(long millis) {
        return getChineseZodiac(millis2Date(millis));
    }

    /**
     * ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取生肖
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：date Date 类型时间
     * ╟──────────────────────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：生肖
     * ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getChineseZodiac(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return CHINESE_ZODIAC[cal.get(Calendar.YEAR) % 12];
    }

}
