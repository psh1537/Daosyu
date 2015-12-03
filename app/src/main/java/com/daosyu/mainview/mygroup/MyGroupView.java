package com.daosyu.mainview.mygroup;

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
 * Created by parksh on 2015-12-01.
 */
public class MyGroupView extends LinearLayout {
    ArrayList<MyGroupData> groupList = new ArrayList<MyGroupData>();
    ImageView profile_image;
    TextView small_group_name, small_group_title, group_people_number;
    LayoutInflater inflater;
    View layoutView;

    public MyGroupView(Context context) {
        super(context);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutView = inflater.inflate(R.layout.mygroup_list_layout, null);

        profile_image = (ImageView)layoutView.findViewById(R.id.profile_image);

        small_group_name = (TextView)layoutView.findViewById(R.id.small_group_name);
        small_group_title = (TextView)layoutView.findViewById(R.id.small_group_title);
        group_people_number = (TextView)layoutView.findViewById(R.id.group_people_number);

    }

    public MyGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View getLayoutView(){
        return layoutView;
    }

    public void setData(MyGroupData mdata){
        profile_image.setImageResource(mdata.getProfile_image());
        small_group_name.setText(mdata.getSmall_group_name());
        small_group_title.setText(mdata.getSmall_group_title());
        group_people_number.setText(mdata.getGroup_people_number());
    }
}
