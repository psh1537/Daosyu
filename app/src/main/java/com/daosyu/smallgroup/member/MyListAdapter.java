package com.daosyu.smallgroup.member;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-12-11.
 */
public class MyListAdapter extends BaseExpandableListAdapter{
    private Context context;
    private ArrayList<Continent> continents;
    private ArrayList<Continent> orignList;

    public MyListAdapter(Context context, ArrayList<Continent> continents){
        this.context = context;
        this.continents = new ArrayList<Continent>();
        this.continents.addAll(continents);
        this.orignList = new ArrayList<Continent>();
        this.orignList.addAll(continents);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<Contry> countryList = continents.get(groupPosition).getContryList();

        return countryList.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Contry contry = (Contry) getChild(groupPosition, childPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.member_list_child_row, null);

        }

        TextView code = (TextView)convertView.findViewById(R.id.code);
        TextView name = (TextView)convertView.findViewById(R.id.contryName);
        TextView population = (TextView)convertView.findViewById(R.id.population);

        code.setText(contry.getCode().trim());
        name.setText(contry.getName().trim());
        population.setText(NumberFormat.getNumberInstance(Locale.KOREA).format(contry.getPopulation()));

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<Contry> countryList = continents.get(groupPosition).getContryList();

        return countryList.size();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return continents.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return continents.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Continent continent = (Continent)getGroup(groupPosition);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.member_list_group_row, null);
        }

        TextView heading = (TextView) convertView.findViewById(R.id.heading);
        heading.setText(continent.getName().trim());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    public void filterData(String query){
        query = query.toLowerCase();
        Log.v("MyListAdapter", String.valueOf(continents.size()));
        continents.clear();

        if(query.isEmpty()){
            continents.addAll(orignList);

        } else {
            for(Continent continent : orignList){
                ArrayList<Contry> countryList = continent.getContryList();
                ArrayList<Contry> newList = new ArrayList<Contry>();

                for(Contry contry : countryList){
                    if(contry.getCode().toLowerCase().contains(query) || contry.getName().toLowerCase().contains(query)){
                        newList.add(contry);
                    }
                }

                if(newList.size() > 0){
                    Continent mContinent = new Continent(newList, continent.getName());
                    continents.add(mContinent);
                }

            }

        }

        Log.v("MyListAdapter", String.valueOf(continents.size()));
        notifyDataSetChanged();
    }


}
