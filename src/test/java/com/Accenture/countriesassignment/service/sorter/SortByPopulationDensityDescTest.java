package com.Accenture.countriesassignment.service.sorter;

import com.Accenture.countriesassignment.domain.country.BaseCountry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SortByPopulationDensityDescTest {

    @Autowired
    private SortByPopulationDensityDesc sorter;

    private BaseCountry c1;
    private BaseCountry c2;
    private BaseCountry c3;
    private List<BaseCountry> countries;

    @BeforeEach
    public void init() {
        c1 = new BaseCountry();
        c1.setCca3("AUT");
        c1.setPopulation(8917205);
        c1.setArea(83871.0); //106.3

        c2 = new BaseCountry();
        c2.setCca3("DEU");
        c2.setPopulation(83240525);
        c2.setArea(357114.0); //233,09

        c3 = new BaseCountry();
        c3.setCca3("USA");
        c3.setPopulation(329484123);
        c3.setArea(9372610.0); //35,15

        countries = new ArrayList<>();
        countries.add(c1);
        countries.add(c2);
        countries.add(c3);
    }

    @Test
    public void sortInCorrectOrder_whenDataIsValid() {
        List<BaseCountry> sortedCountries = sorter.sort(countries);
        Assertions.assertEquals(c2, sortedCountries.get(0));
        Assertions.assertEquals(c1, sortedCountries.get(1));
        Assertions.assertEquals(c3, sortedCountries.get(2));
    }

    @Test
    public void sortInCorrectOrder_whenPopulationIsNull() {

        c3.setPopulation(null);
        List<BaseCountry> sortedCountries = sorter.sort(countries);
        Assertions.assertEquals(c2, sortedCountries.get(0));
        Assertions.assertEquals(c1, sortedCountries.get(1));
        Assertions.assertEquals(c3, sortedCountries.get(2));
    }

    @Test
    public void sortInCorrectOrder_whenAreaIsNull() {

        c3.setArea(null);
        List<BaseCountry> sortedCountries = sorter.sort(countries);
        Assertions.assertEquals(c2, sortedCountries.get(0));
        Assertions.assertEquals(c1, sortedCountries.get(1));
        Assertions.assertEquals(c3, sortedCountries.get(2));
    }

    @Test
    public void sortInCorrectOrder_whenAreaIsZero() {

        c3.setArea(0d);
        List<BaseCountry> sortedCountries = sorter.sort(countries);
        Assertions.assertEquals(c2, sortedCountries.get(0));
        Assertions.assertEquals(c1, sortedCountries.get(1));
        Assertions.assertEquals(c3, sortedCountries.get(2));
    }

}
