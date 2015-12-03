package com.daosyu.smallgroup.information;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.daosyu.smallgroup.SmallGroupActivity;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-30.
 */
public class InformationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_information_layout);
    }

    public void createInfo(View view){
        if(view.getId() == R.id.creatInfo){
            Intent intent = new Intent(this, SmallGroupActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
