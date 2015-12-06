package com.daosyu.mainview;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.daosyu.mainview.myprofile.MyProfileAdapter;

import java.util.List;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-23.
 */
public class MainViewActivity extends AppCompatActivity {
    ViewPager viewPager;
    MainAdapter mainAdapter;
    private BackPressCloseHandler backPressCloseHandler;
    Toolbar toolbar;
    MyProfileAdapter myProfileAdapter;
    DrawerLayout drawerLayout;
    FrameLayout frameLayout;
    ActionBarDrawerToggle toggle;
    ListView listView;
    Button my_group, news, find_group, group_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview_layout);

        my_group = (Button)findViewById(R.id.my_group);
        news = (Button)findViewById(R.id.news);
        find_group = (Button)findViewById(R.id.find_group);
        group_notice = (Button)findViewById(R.id.group_notice);


        toolbar = (Toolbar)findViewById(R.id.toolbar);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        listView = (ListView)findViewById(R.id.MainViewListView);
        drawerLayout = (DrawerLayout)findViewById(R.id.DrawerLayout);
        frameLayout = (FrameLayout)findViewById(R.id.MainFrame);
        mainAdapter = new MainAdapter(getSupportFragmentManager());
        myProfileAdapter = new MyProfileAdapter(this);

        listView.setAdapter(myProfileAdapter);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        viewPager.setAdapter(mainAdapter);
        viewPager.setOffscreenPageLimit(3);

        backPressCloseHandler = new BackPressCloseHandler(this);
        toolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //페이지가 이동 할 때마다 툴바의 제목과 버튼의 배경색이 변함
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    toolbar.setTitle("내모임");
                    my_group.setBackgroundColor(Color.rgb(255,127,80));
                } else {
                    my_group.setBackgroundColor(Color.rgb(0,150,136));
                }

                if (position == 1) {
                    toolbar.setTitle("개인소식");
                    news.setBackgroundColor(Color.rgb(255,127,80));
                } else {
                    news.setBackgroundColor(Color.rgb(0,150,136));
                }

                if (position == 2) {
                    toolbar.setTitle("모임찾기");
                    find_group.setBackgroundColor(Color.rgb(255,127,80));
                } else {
                    find_group.setBackgroundColor(Color.rgb(0,150,136));
                }

                if (position == 3) {
                    toolbar.setTitle("모임공지");
                    group_notice.setBackgroundColor(Color.rgb(255,127,80));
                } else {
                    group_notice.setBackgroundColor(Color.rgb(0,150,136));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                listView.bringToFront();
                drawerLayout.requestLayout();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                //Toast.makeText(getApplicationContext(), "닫혔습니다", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


    }

    public void menuClick(View view){
        switch (view.getId()){
            case R.id.my_group:
                viewPager.setCurrentItem(0, true);
                toolbar.setTitle("내모임");

                break;

            case R.id.news:
                viewPager.setCurrentItem(1, true);
                toolbar.setTitle("개인소식");

                break;

            case R.id.find_group:
                viewPager.setCurrentItem(2, true);
                toolbar.setTitle("모임찾기");

                break;

            case R.id.group_notice:
                viewPager.setCurrentItem(3, true);
                toolbar.setTitle("모임공지");

                break;
        }
    }



    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item)){

            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

}
