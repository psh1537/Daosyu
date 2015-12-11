package com.daosyu.smallgroup.member;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.widget.ExpandableListView;

import com.daosyu.mainview.MainViewActivity;

import java.util.ArrayList;

import daosyu.com.snslogin.R;

/**
 * Created by parksh on 2015-11-24.
 */
public class FindMemberActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchView.OnCloseListener{
    private SearchView searchView;
    private MyListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<Continent> continentList = new ArrayList<Continent>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_member_list_layout);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);

        displayList();

        expandAll();

    }

    private void expandAll(){
        int count = listAdapter.getGroupCount();
        for(int i=0; i < count; i++){
            myList.expandGroup(i);
        }
    }

    private void displayList(){
        loadSomeData();
        myList = (ExpandableListView) findViewById(R.id.expandMenu);

        listAdapter = new MyListAdapter(this, continentList);

        myList.setAdapter(listAdapter);
    }

    private void loadSomeData(){
        ArrayList<Contry> contryList = new ArrayList<Contry>();
        Contry contry = new Contry("JPN", "Japan", 100000000);
        contryList.add(contry);
        contry = new Contry("KOR", "Korea", 48800000);
        contryList.add(contry);
        contry = new Contry("USA", "United States", 550000000);
        contryList.add(contry);
        contry = new Contry("CAN", "Canada", 200000000);
        contryList.add(contry);

        Continent continent = new Continent(contryList, "First Group");
        continentList.add(continent);

        contry = new Contry("CHN", "China", 965000000);
        contryList.add(contry);
        contry = new Contry("HON", "HongKong", 200000000);
        contryList.add(contry);
        contry = new Contry("AUS", "Austria", 127000000);
        contryList.add(contry);
        contry = new Contry("RUS", "Russia", 185000000);
        contryList.add(contry);

        continent = new Continent(contryList, "Second Group");
        continentList.add(continent);
    }

    @Override
    public boolean onClose() {
        listAdapter.filterData("");
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapter.filterData(newText);
        expandAll();
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        listAdapter.filterData(query);
        expandAll();
        return false;
    }
}
