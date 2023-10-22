package com.Accenture.countriesassignment.service.filter;

import com.Accenture.countriesassignment.domain.country.BaseCountry;

import java.util.List;

public interface SingleFilter {
    public BaseCountry filter(List<BaseCountry> countries);
}
