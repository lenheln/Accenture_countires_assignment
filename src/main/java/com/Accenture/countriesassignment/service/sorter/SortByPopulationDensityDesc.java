package com.Accenture.countriesassignment.service.sorter;

import com.Accenture.countriesassignment.domain.country.BaseCountry;
import com.Accenture.countriesassignment.domain.country.utils.CountryPopulationDensity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("sortByPopulationDensityDesc")
public class SortByPopulationDensityDesc implements Sorter {

    @Autowired
    CountryPopulationDensity density;

    @Override
    public List<BaseCountry> sort(List<BaseCountry> countries) {
        countries.sort((c1, c2) -> {
            double differ = density.count(c2) - density.count(c1);
            return (int) differ;
        });
        return countries;
    }
}
