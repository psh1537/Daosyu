package com.daosyu.creategroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.daosyu.smallgroup.SmallGroupActivity;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-25.
 */
public class CreateGroupActivity extends Activity {
    final int REQ_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_group_layout);
    }

    public void groupJoin(View view){
        if(view.getId() == R.id.group_join){
            Intent intent = new Intent(this, SmallGroupActivity.class);
            //intent.putExtra();
            startActivity(intent);
            finish();
        }

        if(view.getId() == R.id.upload_image){
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
            intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, REQ_CODE);
        }


    }
}
