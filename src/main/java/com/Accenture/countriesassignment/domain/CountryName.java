package com.Accenture.countriesassignment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountryName {
    private Map<String,NativeName> nativeName;
    private String official;
    private String common;
}
