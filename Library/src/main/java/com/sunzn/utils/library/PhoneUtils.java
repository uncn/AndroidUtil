package com.sunzn.utils.library;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

import java.util.List;

public class PhoneUtils {

    private PhoneUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：判断设备是否是手机
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：{true : 是} {false : 否}
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean isPhone(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null && tm.getPhoneType() != TelephonyManager.PHONE_TYPE_NONE;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：判断SIM卡是否准备好
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：{true : 是} {false : 否}
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static boolean isSimCardReady(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null && tm.getSimState() == TelephonyManager.SIM_STATE_READY;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：获取SIM卡运营商名称
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context 上下文
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：SIM卡运营商名称（中国移动、如中国联通、中国电信）
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static String getSimOperatorName(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null ? tm.getSimOperatorName() : null;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：跳至拨号界面
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：phoneNumber 电话号码
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void dial(Context context, String phoneNumber) {
        context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber)));
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：拨打电话
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：phoneNumber 电话号码
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 权限：<uses-permission android:name="android.permission.CALL_PHONE"/>
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void call(Context context, String phoneNumber) {
        context.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + phoneNumber)));
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：跳至发送短信界面
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：phoneNumber 接收号码
     * ║ 参数：content     短信内容
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void sendSms(Context context, String phoneNumber, String content) {
        Uri uri = Uri.parse("smsto:" + (StringUtils.isEmpty(phoneNumber) ? "" : phoneNumber));
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", StringUtils.isEmpty(content) ? "" : content);
        context.startActivity(intent);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：发送短信
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：context     上下文
     * ║ 参数：phoneNumber 接收号码
     * ║ 参数：content     短信内容
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 权限：<uses-permission android:name="android.permission.SEND_SMS"/>
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：void
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static void sendSmsSilent(Context context, String phoneNumber, String content) {
        if (StringUtils.isEmpty(content)) return;
        PendingIntent sentIntent = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
        SmsManager smsManager = SmsManager.getDefault();
        if (content.length() >= 70) {
            List<String> ms = smsManager.divideMessage(content);
            for (String str : ms) {
                smsManager.sendTextMessage(phoneNumber, null, str, sentIntent, null);
            }
        } else {
            smsManager.sendTextMessage(phoneNumber, null, content, sentIntent, null);
        }
    }

}