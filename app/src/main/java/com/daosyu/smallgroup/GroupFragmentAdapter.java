package com.daosyu.smallgroup;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by parksh on 2015-11-25.
 */
public class GroupFragmentAdapter extends FragmentStatePagerAdapter {
    Fragment[] gfragments = new Fragment[4];


    public GroupFragmentAdapter(FragmentManager fm) {
        super(fm);
        gfragments[0] = new InformationFragment();
        gfragments[1] = new JungmoFragment();
        gfragments[2] = new GroupPictureFragment();
        gfragments[3] = new MemberFragment();

    }

    @Override
    public Fragment getItem(int position) {
        return gfragments[position];
    }

    @Override
    public int getCount() {
        return gfragments.length;
    }
}
