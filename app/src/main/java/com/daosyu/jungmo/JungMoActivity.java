package com.daosyu.jungmo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daosyu.smallgroup.SmallGroupActivity;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-24.
 */
public class JungMoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_jungmo_layout);


    }

    public void setting(View view){
        if(view.getId() == R.id.setImage){

        }

        if(view.getId() == R.id.setJungmo){
            Intent intent = new Intent(this, SmallGroupActivity.class);
            //intent.putExtra();
            startActivity(intent);
            finish();
        }
    }
}
