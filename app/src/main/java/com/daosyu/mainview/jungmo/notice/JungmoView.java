package com.daosyu.mainview.jungmo.notice;

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
 * Created by parksh on 2015-11-30.
 */
public class JungmoView extends LinearLayout {
    ArrayList<JungMoData> jungmoList = new ArrayList<JungMoData>();
    ImageView jungmo_image;
    TextView small_group_name, jungmo_subject, jungmo_location;
    LayoutInflater inflater;
    View layoutView;

    public JungmoView(Context context) {
        super(context);

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutView = inflater.inflate(R.layout.jungmo_notice_list_layout, null);

        jungmo_image = (ImageView)layoutView.findViewById(R.id.jungmo_image);

        small_group_name = (TextView)layoutView.findViewById(R.id.small_group_name);
        jungmo_subject = (TextView)layoutView.findViewById(R.id.jungmo_subject);
        jungmo_location = (TextView)layoutView.findViewById(R.id.jungmo_location);

    }

    public View getLayoutView(){
        return layoutView;
    }

    public void setData(JungMoData jdata){
        jungmo_image.setImageResource(jdata.getJungmo_image());
        small_group_name.setText(jdata.getSmall_group_name());
        jungmo_subject.setText(jdata.getJungmo_subject());
        jungmo_location.setText(jdata.getJungmo_location());
    }

    public JungmoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
