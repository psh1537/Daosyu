package com.daosyu.mainview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-24.
 */
public class NewsAdapter extends BaseAdapter {
    ArrayList<NewsData> list = new ArrayList<NewsData>();
    int[] img = {R.drawable.iron, R.drawable.human};
    int[] newsImg = {R.drawable.gs, R.drawable.night};
    LayoutInflater inflater;
    Context context;

    public NewsAdapter(Context context) {
        this.context = context;

        for(int i=0; i<2; i++){
            NewsData dto = new NewsData();
            dto.setProfile_image(img[i]);
            dto.setProfile_name("홍길동" + i);
            dto.setNews_regdate("2015년 11월 25일" + i + " 일");
            dto.setNews_title("모임 공지 입니다!");
            dto.setNews_image(newsImg[i]);

            list.add(dto);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if(convertView == null){
            NewsView nv = new NewsView(context);
            NewsData dto = list.get(position);
            nv.setData(dto);
            view = nv.getLayoutView();
        } else{
           view = convertView;
        }

        return view;
    }
}
