package com.daosyu.smallgroup;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.daosyu.smallgroup.member.FindMemberActivity;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-24.
 */
public class MemberFragment extends Fragment {
    Button find_member;
    final int REQ_CODE = 10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_member_layout, container, false);
        find_member = (Button)view.findViewById(R.id.findMember);

        find_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.findMember){
                    Intent intent = new Intent(getActivity(), FindMemberActivity.class);
                    startActivityForResult(intent, REQ_CODE);

                }
            }
        });

        return  view;
    }
}
