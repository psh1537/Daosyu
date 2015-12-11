package com.daosyu.smallgroup.member;

/**
 * Created by parksh on 2015-12-11.
 */
public class Contry {
    private String code = "";
    private String name= "";
    private int population = 0;

    public Contry(String code, String name, int population) {
        super();
        this.code = code;
        this.name = name;
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
