package com.Accenture.countriesassignment;

import com.Accenture.countriesassignment.domain.BaseCountry;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class CountryJsonParserImpl implements CountryJsonParserInt {

    private static final Logger log = Logger.getLogger(CountryJsonParserImpl.class.getName());

    @Override
    public List<BaseCountry> parse(String json) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<BaseCountry> countries = new ArrayList<>();
        try {
            countries = mapper.readValue(json, new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            log.warning(e.getMessage());
        }
        return countries;
    }
}
