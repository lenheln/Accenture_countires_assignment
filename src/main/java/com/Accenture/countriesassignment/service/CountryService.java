package com.Accenture.countriesassignment.service;

import com.Accenture.countriesassignment.service.requestSender.RequestSender;
import com.Accenture.countriesassignment.service.requestSender.IRequestSender;
import com.Accenture.countriesassignment.domain.country.BaseCountry;
import com.Accenture.countriesassignment.service.filter.SingleFilter;
import com.Accenture.countriesassignment.service.jsonParser.ICountryJsonParser;
import com.Accenture.countriesassignment.service.sorter.Sorter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class CountryService {

    private static final Logger log = Logger.getLogger(CountryService.class.getName());
    private static final String baseUrl = "https://restcountries.com/v3.1/";

    private final IRequestSender sender;
    private final ICountryJsonParser parser;
    private final Sorter sorter;
    private final SingleFilter filter;

    public CountryService(RequestSender sender, ICountryJsonParser parser, Sorter sorter, SingleFilter filter) {
        this.sender = sender;
        this.parser = parser;
        this.sorter = sorter;
        this.filter = filter;
    }

    public List<BaseCountry> sortCounties() {
        List<BaseCountry> countries = getAllCountries();
        return sorter.sort(countries);
    }

    public BaseCountry filterCountries () {
        List<BaseCountry> countries = getAllCountries();
        return filter.filter(countries);
    }

    private List<BaseCountry> getAllCountries() {
        String response = sender.send(baseUrl + "all");
        return parser.parse(response);
    }
}
