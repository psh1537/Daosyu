package com.daosyu.smallgroup;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.daosyu.jungmo.JungMoActivity;
import com.daosyu.smallgroup.information.InformationAdapter;
import com.daosyu.smallgroup.jungmo.JungmoAdapter;
import com.daosyu.smallgroup.jungmo.JungmoMasterDetailActivity;

import java.util.List;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-24.
 */
public class JungmoFragment extends Fragment {
    Button write_info;
    JungmoAdapter jungmoAdapter;
    ListView jungListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jungmo_layout, container, false);
        //getActivity().setTitle("정모");

        jungListView = (ListView)view.findViewById(R.id.jungmo_view);
        jungmoAdapter = new JungmoAdapter(getActivity());
        jungListView.setAdapter(jungmoAdapter);

        write_info = (Button)view.findViewById(R.id.write_info);

        jungListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), JungmoMasterDetailActivity.class);
                startActivity(intent);

            }
        });

        write_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.write_info){
                    Intent intent = new Intent(getActivity(), JungMoActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        return view;
    }
}
