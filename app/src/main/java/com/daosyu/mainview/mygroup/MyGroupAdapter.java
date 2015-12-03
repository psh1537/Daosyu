package com.daosyu.mainview.mygroup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-12-01.
 */
public class MyGroupAdapter extends BaseAdapter {
    ArrayList<MyGroupData> groupList = new ArrayList<MyGroupData>();
    int img[] = {R.drawable.iron, R.drawable.cap, R.drawable.spidy, R.drawable.loki, R.drawable.green};
    String[] small_group_name = {"영화와 커피가 만날때", "돌아돌아 돈이돌아", "등산 오르기", "농활 하실분?", "고기잡이 하실분?"};
    String[] small_group_title = {"간단하게 영화보실분", "안녕하세요!", "설악산 모임 입니다", "전주시 농활 갑니다", "울릉도 오징어 잡이 갑니다."};
    String[] group_people_number = {"15", "10", "7", "9", "5"};
    Context context;

    public MyGroupAdapter(Context context) {
        this.context = context;

        for(int i=0; i<5; i++){
            MyGroupData dto = new MyGroupData();
            dto.setProfile_image(img[i]);
            dto.setSmall_group_name(small_group_name[i]);
            dto.setSmall_group_title(small_group_title[i]);
            dto.setGroup_people_number(group_people_number[i]);

            groupList.add(dto);
        }
    }

    @Override
    public int getCount() {
        return groupList.size();
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
            MyGroupView mgView = new MyGroupView(context);
            MyGroupData mgData = groupList.get(position);
            mgView.setData(mgData);
            view = mgView.getLayoutView();

        } else {
            view = convertView;
        }
        return view;
    }
}
