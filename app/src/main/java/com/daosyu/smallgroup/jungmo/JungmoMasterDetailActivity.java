package com.daosyu.smallgroup.jungmo;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-12-01.
 */
public class JungmoMasterDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_jungmo_notice_detail_layout);

    }

    public void btnManipulate(View view){
        if(view.getId() == R.id.jungmo_update){
            Toast.makeText(this, "수정", Toast.LENGTH_SHORT).show();
        }

        if(view.getId() == R.id.jungmo_delete){
            Toast.makeText(this, "삭제", Toast.LENGTH_SHORT).show();
        }
    }
}
