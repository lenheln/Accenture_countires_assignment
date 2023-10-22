package com.Accenture.countriesassignment.service.jsonParser;

import com.Accenture.countriesassignment.domain.country.BaseCountry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CountryJsonParserTest {

    @Autowired
    CountryJsonParser parser;

    @Test
    public void shouldReturnEmptyList_whenResponseIsNull() {
        List<BaseCountry> countries = parser.parse(null);
        Assertions.assertTrue(countries.isEmpty());
    }

    @Test
    public void shouldReturnEmptyList_whenResponseIsEmpty() {
        List<BaseCountry> countries = parser.parse("");
        Assertions.assertTrue(countries.isEmpty());
    }
}
