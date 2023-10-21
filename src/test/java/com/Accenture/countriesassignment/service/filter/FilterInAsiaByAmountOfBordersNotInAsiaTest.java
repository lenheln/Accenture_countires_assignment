package com.Accenture.countriesassignment.service.filter;

import com.Accenture.countriesassignment.domain.country.BaseCountry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FilterInAsiaByAmountOfBordersNotInAsiaTest {

    @Autowired
    FilterInAsiaByAmountOfBordersNotInAsia filter;

    private BaseCountry c1;
    private BaseCountry c2;
    private BaseCountry c3;
    private BaseCountry c4;
    private BaseCountry c5;

    private List<BaseCountry> countries;

    @BeforeEach
    public void init() {
        c1 = new BaseCountry();
        c1.setCca3("CODE_A_1");
        c1.setRegion("Asia");
        c1.setBorders(List.of("CODE_E_1", "CODE_E_2"));

        c2 = new BaseCountry();
        c2.setCca3("CODE_A_2");
        c2.setRegion("Asia");
        c2.setBorders(List.of("CODE_A_1", "CODE_A_3", "CODE_E_1"));

        c3 = new BaseCountry();
        c3.setCca3("CODE_A_3");
        c3.setRegion("Europe");
        c3.setBorders(List.of("CODE_E_1", "CODE_E_2", "CODE_A_1", "CODE_A_2"));

        c4 = new BaseCountry();
        c4.setCca3("CODE_E_1");
        c4.setRegion("Europe");
        c4.setBorders(List.of("CODE_E_2"));

        c5 = new BaseCountry();
        c5.setCca3("CODE_E_2");
        c5.setRegion("Europe");
        c5.setBorders(List.of("CODE_E_1"));

        countries = new ArrayList<>();
        countries.add(c1);
        countries.add(c2);
        countries.add(c3);
        countries.add(c4);
        countries.add(c5);
    }

    @Test
    public void filter_returnCorrectCountry_whenDataIsValid() {
        BaseCountry c = filter.filter(countries);
        Assertions.assertEquals(c1, c);
    }

    @Test
    public void filter_returnCorrectCountry_whenRegionIsNull() {
        c4.setRegion(null);
        BaseCountry c = filter.filter(countries);
        Assertions.assertEquals(c1, c);
    }

    @Test
    public void filter_returnCorrectCountry_whenBordersIsNull() {
        BaseCountry c6 = new BaseCountry();
        c6.setCca3("CODE_E_3");
        c6.setRegion("Asia");
        countries.add(c6);

        BaseCountry c = filter.filter(countries);
        Assertions.assertEquals(c1, c);
    }

    @Test
    public void findCountryByCode_returnCorrectCountry_whenCodeCantBeFound() {
        countries.remove(c3);
        BaseCountry c = filter.filter(countries);
        Assertions.assertEquals(c1, c);
    }
}
