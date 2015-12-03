package com.daosyu.mainview.findgroup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;



import java.util.ArrayList;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-30.
 */
public class FindGroupAdapter extends BaseAdapter {
    ArrayList<FindGroupData> findList = new ArrayList<FindGroupData>();
    int img[] = {R.drawable.iron, R.drawable.night, R.drawable.human};
    String[] smallName = {"영화와 커피가 만날때", "등산과 함께 해요", "원피스 좋아하는 분"};
    String[] samllTitle = {"주말에 영화 한편 보실분", "시간내서 높은 산 오르실분 모이세요!", "원피스 좋아하는 분"};
    String[] smallLocatio={"서울시", "인제시", "온라인 활동"};
    Context context;

    public FindGroupAdapter(Context context) {
        this.context = context;

        for(int i=0; i<3; i++){
            FindGroupData dto = new FindGroupData();
            dto.setSmall_group_image(img[i]);
            dto.setSmall_group_name(smallName[i]);
            dto.setSmall_grou_title(samllTitle[i]);
            dto.setSmall_group_location(smallLocatio[i]);

            findList.add(dto);
        }
    }

    @Override
    public int getCount() {
        return findList.size();
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
            FindGroupView findView = new FindGroupView(context);
            FindGroupData findData = findList.get(position);
            findView.setData(findData);
            view = findView.getLayoutView();

        } else {
            view = convertView;
        }

        return view;
    }
}
