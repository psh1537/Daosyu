package com.daosyu.smallgroup.information;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-12-01.
 */
public class InformationAdapter extends BaseAdapter {
    ArrayList<InformationData> infoList = new ArrayList<InformationData>();
    TextView info_name, info_detail;
    ImageButton menu_button;
    String[] infoName = {"안녕하세요", "11월 25일 공지사항", "검은 사제들 개봉", "007 스팩터 개봉", "내부자들 개봉!"};
    String[] infoDetail = {"반가워요!!","장소는 cgv로...","보실분 강변역 cgv로..","보실분 강변역 cgv로..","보실분 강변역 cgv로.."};
    ListPopupWindow listpop;
    Context context;

    public InformationAdapter(Context context) {
        this.context = context;

        for(int i=0; i<5; i++){
            InformationData dto = new InformationData();
            dto.setInfo_name(infoName[i]);
            dto.setInfo_deatil(infoDetail[i]);

            infoList.add(dto);
        }
    }

    @Override
    public int getCount() {
        return infoList.size();
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
        final String[] msg = {"수정", "삭제"};

        if(convertView == null){
            InformationView infoView = new InformationView(context);
            InformationData infoData = infoList.get(position);
            infoView.setData(infoData);

            view = infoView.getLayoutView();
        } else {
            view = convertView;
        }
        return view;
    }
}
