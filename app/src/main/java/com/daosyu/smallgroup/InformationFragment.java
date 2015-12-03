package com.daosyu.smallgroup;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.ListView;

import com.daosyu.smallgroup.information.InformationActivity;
import com.daosyu.smallgroup.information.InformationAdapter;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-24.
 */
public class InformationFragment extends Fragment {
    Button button;
    InformationAdapter informationAdapter;
    ListView inforView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.information_notice_layout, container, false);

        inforView = (ListView)view.findViewById(R.id.information_view);
        informationAdapter = new InformationAdapter(getActivity());



        inforView.setAdapter(informationAdapter);

        button = (Button)view.findViewById(R.id.write_info);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.write_info){
                    Intent intent = new Intent(getActivity(), InformationActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        //getActivity().setTitle("정보");

        return view;
    }
}
