package com.donggua.webpackage;

import org.springframework.context.annotation.ComponentScan;

/**
 * Created by HP on 2017/7/10.
 */

public class Country {

    private int country_id;
    private String country;



    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
