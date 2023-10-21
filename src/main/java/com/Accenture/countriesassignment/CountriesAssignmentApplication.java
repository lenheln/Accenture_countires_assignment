package com.Accenture.countriesassignment;

import com.Accenture.countriesassignment.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesAssignmentApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CountriesAssignmentApplication.class, args);
	}

	@Autowired
	private CountryService service;

	@Override
	public void run(String...args) {
		service.filterCountries();
		service.sortCounties();
	}

}
