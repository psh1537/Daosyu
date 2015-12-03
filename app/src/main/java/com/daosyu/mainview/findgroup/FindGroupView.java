package com.daosyu.mainview.findgroup;

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
public class FindGroupView extends LinearLayout{
    ArrayList<FindGroupData> findList = new ArrayList<FindGroupData>();
    ImageView small_group_image;
    TextView small_group_name, small_group_title, small_group_location;
    LayoutInflater inflater;
    View layoutView;

    public FindGroupView(Context context) {
        super(context);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutView = inflater.inflate(R.layout.findgroup_list_layout, null);

        small_group_image = (ImageView)layoutView.findViewById(R.id.small_group_image);

        small_group_name = (TextView)layoutView.findViewById(R.id.small_group_name);
        small_group_title = (TextView)layoutView.findViewById(R.id.small_group_title);
        small_group_location = (TextView)layoutView.findViewById(R.id.small_group_location);

    }

    public View getLayoutView(){
        return layoutView;
    }

    public void setData(FindGroupData findData){
        small_group_image.setImageResource(findData.getSmall_group_image());
        small_group_name.setText(findData.getSmall_group_name());
        small_group_title.setText(findData.getSmall_grou_title());
        small_group_location.setText(findData.getSmall_group_location());
    }

    public FindGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
