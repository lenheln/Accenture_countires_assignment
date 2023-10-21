package com.Accenture.countriesassignment.domain.country;

import lombok.*;

import java.util.Map;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NativeName {
    private String official;
    private String common;
}
