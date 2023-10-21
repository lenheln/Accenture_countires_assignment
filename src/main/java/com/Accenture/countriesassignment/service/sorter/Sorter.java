package com.Accenture.countriesassignment.service.sorter;

import com.Accenture.countriesassignment.domain.country.BaseCountry;

import java.util.List;

public interface Sorter {

    List<BaseCountry> sort(List<BaseCountry> countries);
    
}
