package com.daosyu.smallgroup.information;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-12-01.
 */
public class InformationView extends LinearLayout {
    ArrayList<InformationData> infoList = new ArrayList<InformationData>();
    ImageButton menu_button;
    TextView info_name, info_detail;
    LayoutInflater inflater;
    View layoutView;
    ListPopupWindow listpop;
    String[] msg = {"수정", "삭제"};

    public InformationView(Context context) {
        super(context);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutView = inflater.inflate(R.layout.information_list_layout, null);

        info_name = (TextView)layoutView.findViewById(R.id.info_name);
        info_detail = (TextView)layoutView.findViewById(R.id.info_detail);
        menu_button = (ImageButton)layoutView.findViewById(R.id.menu_button);

        actionButton();
    }

    public void actionButton(){
        //버튼을 누르면 수정, 삭제의 글이 리스트 팝업 형식으로 띄운다

        listpop = new ListPopupWindow(getContext());
        listpop.setWidth(300);
        listpop.setHeight(300);
        listpop.setAnchorView(menu_button); //버튼에 팝업 윈도우를 띄운다
        listpop.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, msg));

        listpop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(getContext(), "수정", Toast.LENGTH_SHORT).show();

                } else if (position == 1) {
                    Toast.makeText(getContext(), "삭제", Toast.LENGTH_SHORT).show();
                }
            }
        });


        menu_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v.getId() == R.id.menu_button){
                    if(listpop.isShowing()){
                        listpop.dismiss();

                    } else {
                        listpop.show();
                    }

                }
            }
        });
    }

    public View getLayoutView(){
        return layoutView;
    }

    public void setData(InformationData infoData){
        info_name.setText(infoData.getInfo_name());
        info_detail.setText(infoData.getInfo_deatil());
    }

    public InformationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
