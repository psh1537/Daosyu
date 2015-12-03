package com.daosyu.mainview.myprofile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-12-02.
 */
public class MyProfileView extends LinearLayout {
    ArrayList<MyProfileData> profileList = new ArrayList<MyProfileData>();
    ImageView profile_image;
    TextView group_number, jungmo_number, profile_name;
    Button profile_image_upload;
    Button create_group;
    Button change_location;
    Button call;
    LayoutInflater inflater;
    View layoutView;

    public MyProfileView(Context context) {
        super(context);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutView = inflater.inflate(R.layout.profile_layout, null);

        profile_image = (ImageView)layoutView.findViewById(R.id.profile_image);
        profile_name = (TextView)layoutView.findViewById(R.id.profile_name);
        group_number = (TextView)layoutView.findViewById(R.id.group_number);
        jungmo_number = (TextView)layoutView.findViewById(R.id.jungmo_number);

        profile_image_upload = (Button)layoutView.findViewById(R.id.profile_image_upload);
        create_group = (Button)layoutView.findViewById(R.id.create_group);
        change_location = (Button)layoutView.findViewById(R.id.change_location);
        call = (Button)layoutView.findViewById(R.id.call);

        ButtonAction();
    }

    public void ButtonAction(){
        profile_image_upload.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "이미지 업로드", Toast.LENGTH_SHORT).show();
            }
        });

        create_group.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "모임 만들기", Toast.LENGTH_SHORT).show();
            }
        });

        change_location.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "지역 바꾸기", Toast.LENGTH_SHORT).show();
            }
        });

        call.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "문의", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public View getLayoutView(){
        return layoutView;
    }

    public void setData(MyProfileData proData){
        profile_image.setImageResource(proData.getProfile_image());
        profile_name.setText(proData.getProfile_name());
        jungmo_number.setText(proData.getJungmo_number());
        group_number.setText(proData.getGroup_number());
    }

    public MyProfileView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
