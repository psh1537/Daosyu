package com.daosyu.mainview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.daosyu.creategroup.CreateGroupActivity;
import com.daosyu.jungmo.JungMoActivity;
import com.daosyu.mainview.findgroup.FindGroupAdapter;
import com.daosyu.mainview.mygroup.MyGroupAdapter;
import com.daosyu.smallgroup.SmallGroupActivity;

import java.util.ArrayList;
import java.util.List;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-23.
 */

public class MyGroupFragment extends Fragment {
    MyGroupAdapter myGroupAdapter;
    ListView master_view, mygroup_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mygroup_layout, container, false);

        master_view = (ListView)view.findViewById(R.id.master_view);
        mygroup_view = (ListView)view.findViewById(R.id.mygroup_view);
        myGroupAdapter = new MyGroupAdapter(getActivity());

        master_view.setAdapter(myGroupAdapter);
        mygroup_view.setAdapter(myGroupAdapter);

        //내가 그룹장인 경우...
        master_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                moveActivity();
            }
        });

        //내가 그룹원인 경우...
        mygroup_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                moveActivity();
            }
        });

        Button button = (Button) view.findViewById(R.id.createGroup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateGroupActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


    public void moveActivity(){
        Intent intent = new Intent(getActivity(), SmallGroupActivity.class);
        startActivity(intent);
    }


}
