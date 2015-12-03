package com.daosyu.mainview;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by parksh on 2015-11-23.
 */
public class MainAdapter extends FragmentStatePagerAdapter {
    Fragment[] fragments = new Fragment[4];

    public MainAdapter(FragmentManager fm) {
        super(fm);
        fragments[0] = new MyGroupFragment();
        fragments[1] = new NewsFragment();
        fragments[2] = new FindGroupFragment();
        fragments[3] = new NoticeGroupFragment();
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public Fragment getItem(int position) {

        return fragments[position];
    }
}
