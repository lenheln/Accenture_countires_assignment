package com.Accenture.countriesassignment.service.filter;

import com.Accenture.countriesassignment.domain.country.BaseCountry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Qualifier("filterInAsiaByAmountOfBordersNotInAsia")
public class FilterInAsiaByAmountOfBordersNotInAsia implements SingleFilter {

    private static final String region = "Asia";

    @Override
    public BaseCountry filter(List<BaseCountry> countries) {
        return countries.stream()
                .filter(c -> ((c.getRegion() != null) && (c.getRegion().equals(region))))
                .max((c1, c2) -> {
                    long differ = countBordersNotInRegion(c1, countries) - countBordersNotInRegion(c2, countries);
                    return (int) differ;
                })
                .orElse(null);

    }

    private Optional<BaseCountry> findCountryByCode(String code, List<BaseCountry> countries) {
        return countries.stream()
                .filter(c -> c.getCca3().equals(code))
                .findFirst();
    }

    private long countBordersNotInRegion(BaseCountry country, List<BaseCountry> countries) {
        List<String> borders = country.getBorders();
        if(borders != null)
            return borders.stream()
                .map(c -> findCountryByCode(c, countries))
                .filter(Optional::isPresent)
                .filter(c -> ((c.get().getRegion() != null) && (!c.get().getRegion().equals(region))))
                .count();
        return 0L;
    }
}
