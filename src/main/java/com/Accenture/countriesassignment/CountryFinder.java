package com.Accenture.countriesassignment;

import com.Accenture.countriesassignment.domain.BaseCountry;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class CountryFinder {

    private static final Logger log = Logger.getLogger(CountryFinder.class.getName());
    private static final String baseUrl = "https://restcountries.com/v3.1/";

    private final RequestSenderInt sender;
    private final CountryJsonParserInt parser;

    public CountryFinder(RequestSender sender, CountryJsonParserInt parser) {
        this.sender = sender;
        this.parser = parser;
    }

    //todo get respone / parse/ filter
    public List<BaseCountry> findByPopulationDensityDesc() {

        String response = sender.send(baseUrl + "all?fields=name,population,area");
        List<BaseCountry> countries = parser.parse(response);

        return null;
    }

    public BaseCountry findByAmountOfBorders() {
        return null;
    }
}
