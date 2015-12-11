package com.daosyu.test;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import java.util.HashMap;

import daosyu.com.snslogin.MemberActivity;
import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-12-04.
 */
public class TestActivity extends Activity {
    TextView test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

        test = (TextView) findViewById(R.id.test);


        String id = getIntent().getExtras().getString("regionName");
        test.setText(id);

    }
}
