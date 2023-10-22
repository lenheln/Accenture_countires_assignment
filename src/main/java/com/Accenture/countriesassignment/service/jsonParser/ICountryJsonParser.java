package com.Accenture.countriesassignment.service.jsonParser;

import com.Accenture.countriesassignment.domain.country.BaseCountry;

import java.util.List;

public interface ICountryJsonParser {

    List<BaseCountry> parse(String json);
}
