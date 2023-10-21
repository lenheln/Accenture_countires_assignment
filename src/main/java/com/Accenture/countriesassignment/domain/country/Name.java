package com.Accenture.countriesassignment.domain.country;

import lombok.*;

import java.util.Map;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Name {
    private Map<String, NativeName> nativeName;
    private String official;
    private String common;
}
