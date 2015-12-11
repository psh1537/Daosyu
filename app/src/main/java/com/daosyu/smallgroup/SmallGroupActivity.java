package com.daosyu.smallgroup;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import daosyu.com.snslogin.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by parksh on 2015-11-20.
 */
public class SmallGroupActivity extends AppCompatActivity {
    ViewPager viewPager;
    GroupFragmentAdapter groupFragmentAdapter;
    Toolbar toolbar;
    Button group_information, group_jungmo, group_album, group_member;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.small_group_layout);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        group_information = (Button)findViewById(R.id.group_information);
        group_jungmo = (Button)findViewById(R.id.group_jungmo);
        group_album = (Button)findViewById(R.id.group_album);
        group_member = (Button)findViewById(R.id.group_member);

        viewPager = (ViewPager)findViewById(R.id.smallgroupViewPager);
        groupFragmentAdapter = new GroupFragmentAdapter(getSupportFragmentManager());

        viewPager.setAdapter(groupFragmentAdapter);
        viewPager.setOffscreenPageLimit(3);

        toolbar.setTitle("정보");
        toolbar.setTitleTextColor(Color.WHITE);

        group_information.setBackgroundColor(Color.rgb(0, 150, 136));
        group_information.setTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    toolbar.setTitle("정보");
                    group_information.setBackgroundColor(Color.rgb(0, 150, 136));
                    group_information.setTextColor(Color.WHITE);

                }else {
                    group_information.setBackgroundColor(Color.rgb(255, 255, 255));
                    group_information.setTextColor(Color.BLACK);
                }

                if(position == 1){
                    toolbar.setTitle("정모");
                    group_jungmo.setBackgroundColor(Color.rgb(0, 150, 136));
                    group_jungmo.setTextColor(Color.WHITE);
                }else {
                    group_jungmo.setBackgroundColor(Color.rgb(255, 255, 255));
                    group_jungmo.setTextColor(Color.BLACK);
                }

                if(position == 2){
                    toolbar.setTitle("모임사진");
                    group_album.setBackgroundColor(Color.rgb(0, 150, 136));
                    group_album.setTextColor(Color.WHITE);
                }else {
                    group_album.setBackgroundColor(Color.rgb(255, 255, 255));
                    group_album.setTextColor(Color.BLACK);
                }

                if(position == 3){
                    toolbar.setTitle("맴버");
                    group_member.setBackgroundColor(Color.rgb(0, 150, 136));
                    group_member.setTextColor(Color.WHITE);
                } else {
                    group_member.setBackgroundColor(Color.rgb(255, 255, 255));
                    group_member.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            onBackPressed();
        }
        return true;
    }

    public void groupClick(View view){
        switch (view.getId()){
            case R.id.group_information:
                viewPager.setCurrentItem(0, true);
                toolbar.setTitle("정보");
                break;

            case R.id.group_jungmo:
                viewPager.setCurrentItem(1, true);
                toolbar.setTitle("정모");
                break;

            case R.id.group_album:
                viewPager.setCurrentItem(2, true);
                toolbar.setTitle("모임사진");
                break;

            case R.id.group_member:
                viewPager.setCurrentItem(3, true);
                toolbar.setTitle("맴버");
                break;
        }
    }
}
