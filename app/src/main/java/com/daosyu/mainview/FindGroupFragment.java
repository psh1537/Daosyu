package com.daosyu.mainview;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.daosyu.mainview.detail.FindGroupDeatilActivity;
import com.daosyu.mainview.findgroup.FindGroupAdapter;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-23.
 */
public class FindGroupFragment extends Fragment{
    FindGroupAdapter findGroupAdapter;
    ListView findGroupList;
    SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.findgroup_layout, container, false);


        findGroupList = (ListView)view.findViewById(R.id.findgroup_view);
        findGroupAdapter = new FindGroupAdapter(getActivity());
        findGroupList.setAdapter(findGroupAdapter);

        findGroupList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FindGroupDeatilActivity.class);
                startActivity(intent);
            }
        });

        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));


    }
}
