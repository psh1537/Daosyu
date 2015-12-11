package com.daosyu.smallgroup.member;

import java.util.ArrayList;

/**
 * Created by parksh on 2015-12-11.
 */
public class Continent {
    private String name;
    private ArrayList<Contry> contryList = new ArrayList<Contry>();

    public Continent(ArrayList<Contry> contryList, String name) {
        super();
        this.contryList = contryList;
        this.name = name;
    }

    public ArrayList<Contry> getContryList() {
        return contryList;
    }

    public void setContryList(ArrayList<Contry> contryList) {
        this.contryList = contryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
