package com.daosyu.smallgroup;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.daosyu.album.AlbumAdapter;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-24.
 */
public class GroupPictureFragment extends Fragment {
    GridView gridView;
    AlbumAdapter albumAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.album_layout, container, false);
        //getActivity().setTitle("모임사진");

        gridView = (GridView)view.findViewById(R.id.GridAlbum);
        albumAdapter = new AlbumAdapter(getActivity());

        gridView.setAdapter(albumAdapter);

        return view;
    }
}
