package com.Accenture.countriesassignment.domain.country;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter @Getter
@ToString
public class CapitalInformation {
    private List<Double> latlng;
}
