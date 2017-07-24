package com.donggua.webpackage.countrydao;

import com.donggua.webpackage.Country;

import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2017/7/10.
 */
public interface CountryDao {
    Country selectCountryByID(int id);
    void insertCountry(Country country);
    List<Country> selectAllCountriesAndReturnHashMap();
}


class CountryDaoImpl implements CountryDao{

    public Country selectCountryByID(int id){
        return null;
    }

    public void insertCountry(Country country){

    }

    public List<Country> selectAllCountriesAndReturnHashMap(){
        return  null;
    }
}