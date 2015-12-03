package com.daosyu.mainview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-25.
 */
public class NewsView extends LinearLayout {
    ArrayList<NewsData> list = new ArrayList<NewsData>();
    ImageView profile_image, news_image;
    TextView profile_name, news_regdate, news_title;
    LayoutInflater inflater;
    View layoutView;

    public NewsView(Context context) {
        super(context);

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutView = inflater.inflate(R.layout.news_list_layout, null);

        profile_image = (ImageView)layoutView.findViewById(R.id.profile_image);
        news_image = (ImageView)layoutView.findViewById(R.id.news_image);

        profile_name = (TextView)layoutView.findViewById(R.id.profile_name);
        news_regdate = (TextView)layoutView.findViewById(R.id.news_regdate);
        news_title = (TextView)layoutView.findViewById(R.id.news_title);


    }

    public View getLayoutView(){
        return layoutView;
    }

    public void setData(NewsData data){
        profile_image.setImageResource(data.getProfile_image());
        news_image.setImageResource(data.getNews_image());
        //profile_name.setText(data.getProfile_name());
        news_regdate.setText(data.getNews_regdate());
        news_title.setText(data.getNews_title());
    }

    public NewsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
