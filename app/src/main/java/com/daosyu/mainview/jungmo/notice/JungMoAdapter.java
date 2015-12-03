package com.daosyu.mainview.jungmo.notice;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-30.
 */
public class JungMoAdapter extends BaseAdapter {
    ArrayList<JungMoData> jungmoList = new ArrayList<JungMoData>();
    int[] img = {R.drawable.night, R.drawable.iron, R.drawable.iron};
    String[] sName = {"영화와 커피가 만날때", "등산과 함께 해요", "원피스 만화 좋아하는 사람들의 모임"};
    String[] sTitle = {"월요일 오후 타임 영화보기","일요일 설악산 등산 하실분", "원피스 808화 유출"};
    String[] sLoc = {"건대입구 스타시티 롯데시네마", "강원도 인제군", "zangsisi.net"};

    Context context;

    public JungMoAdapter(Context context) {
        this.context = context;

        for(int i=0; i<3; i++){
            JungMoData dto = new JungMoData();
            dto.setJungmo_image(img[i]);
            dto.setSmall_group_name(sName[i]);
            dto.setJungmo_subject(sTitle[i]);
            dto.setJungmo_location(sLoc[i]);

            jungmoList.add(dto);
        }
    }

    @Override
    public int getCount() {
        return jungmoList.size();
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
            JungmoView jmv = new JungmoView(context);
            JungMoData dto = jungmoList.get(position);
            jmv.setData(dto);
            view = jmv.getLayoutView();
        }else {
            view = convertView;
        }
        return view;
    }
}
