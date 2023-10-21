package com.Accenture.countriesassignment;

import com.Accenture.countriesassignment.domain.BaseCountry;

import java.util.List;

public interface CountryJsonParserInt {

    List<BaseCountry> parse(String json);
}
