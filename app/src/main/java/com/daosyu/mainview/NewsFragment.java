package com.daosyu.mainview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-23.
 */
public class NewsFragment extends Fragment{
    NewsAdapter newsAdapter;
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_layout, container, false);

        listView = (ListView)view.findViewById(R.id.news_view);
        newsAdapter = new NewsAdapter(getActivity());
        listView.setAdapter(newsAdapter);

        return view;
    }

}