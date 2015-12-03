package com.daosyu.mainview.detail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.daosyu.smallgroup.SmallGroupActivity;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-30.
 */
public class FindGroupDeatilActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_group_list_detail_layout);

    }

    public void joinGroup(View view){
        if(view.getId() == R.id.group_join){
            Intent intent = new Intent(this, SmallGroupActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
