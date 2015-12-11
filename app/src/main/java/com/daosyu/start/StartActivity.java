package com.daosyu.start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import daosyu.com.snslogin.MainActivity;
import daosyu.com.snslogin.R;

/*
 * Created by parksh on 2015-12-07.
 *
 * 다오슈 앱을 처음 키면 시작하는 화면 3초간 화면을 띄운다.
 */
public class StartActivity extends Activity{
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
