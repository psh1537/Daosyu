package com.daosyu.mainview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.daosyu.mainview.detail.DetailActivity;
import com.daosyu.mainview.jungmo.notice.JungMoAdapter;

import java.util.List;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-23.
 */
public class NoticeGroupFragment extends Fragment{
    JungMoAdapter jungMoAdapter;
    ListView jungmoList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jungmo_notice_layout, container, false);

        jungmoList = (ListView)view.findViewById(R.id.jnotice_view);
        jungMoAdapter = new JungMoAdapter(getActivity());
        jungmoList.setAdapter(jungMoAdapter);

        jungmoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
