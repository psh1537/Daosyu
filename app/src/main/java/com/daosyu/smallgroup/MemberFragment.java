package com.daosyu.smallgroup;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-24.
 */
public class MemberFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //getActivity().setTitle("맴버");
        return inflater.inflate(R.layout.find_member_layout, container, false);
    }
}
