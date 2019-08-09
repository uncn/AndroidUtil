package com.sunzn.utils.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.sunzn.utils.library.ColorUtils;
import com.sunzn.utils.library.StringUtils;
import com.sunzn.utils.library.TimeUtils;
import com.sunzn.utils.library.port.Connector;

import java.text.ParseException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView zz = findViewById(R.id.tv);

        Log.e("TimeUtils", "Year = " + TimeUtils.getStartOfYear());
        Log.e("TimeUtils", "Year = " + TimeUtils.millis2String(TimeUtils.getStartOfYear(), "yyyy-MM-dd HH:mm:ss zzzz"));

        Log.e("TimeUtils", "=======================================");

        Log.e("TimeUtils", "Year = " + TimeUtils.getEndOfYear());
        Log.e("TimeUtils", "Year = " + TimeUtils.millis2String(TimeUtils.getEndOfYear(), "yyyy-MM-dd HH:mm:ss zzzz"));

        try {
            long millis = TimeUtils.string2Millis("2017-08-22T16:42:35", "yyyy-MM-dd'T'HH:mm:ss");

            String time = TimeUtils.millis2String(millis, "yyyy-MM-dd'T'HH:mm:ss");

            zz.setText(time + " == " + millis);

            zz.setText(ColorUtils.signColor("%s - 问题", "关键词", "#FF0000"));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        ArrayList<String> data = new ArrayList<>();

        StringUtils.connectString(data, ";", new Connector<String>() {
            @Override
            public String getString(String s) {
                return null;
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("sunzn", "MainActivity.onRestart()");
    }
}
