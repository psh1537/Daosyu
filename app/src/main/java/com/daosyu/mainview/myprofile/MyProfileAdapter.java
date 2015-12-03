package com.daosyu.mainview.myprofile;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-12-02.
 */
public class MyProfileAdapter extends BaseAdapter{
    ArrayList<MyProfileData> proList = new ArrayList<MyProfileData>();
    int img[] = {R.drawable.cap};
    String[] proName = {"캡틴 아메리카"};
    String[] gNumber = {"10"};
    String[] jNumber = {"2"};
    Context context;

    public MyProfileAdapter(Context context) {
        this.context = context;

        for(int i=0; i<1; i++){
            MyProfileData dto = new MyProfileData();
            dto.setProfile_image(img[i]);
            dto.setProfile_name(proName[i]);
            dto.setGroup_number(gNumber[i]);
            dto.setJungmo_number(jNumber[i]);

            proList.add(dto);
        }
    }


    @Override
    public int getCount() {
        return proList.size();
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
            MyProfileView profileView = new MyProfileView(context);
            MyProfileData myData = proList.get(position);
            profileView.setData(myData);
            view = profileView.getLayoutView();

        } else {
            view = convertView;
        }

        return view;
    }
}
