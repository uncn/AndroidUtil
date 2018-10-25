package com.sunzn.utils.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by sunzn on 2017/7/5.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MALL", "SecondActivity.onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MALL", "SecondActivity.onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MALL", "SecondActivity.onDestroy()");
    }
}