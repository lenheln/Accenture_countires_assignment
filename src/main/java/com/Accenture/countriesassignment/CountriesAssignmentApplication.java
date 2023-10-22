package com.Accenture.countriesassignment;

import com.Accenture.countriesassignment.service.CountryService;
import com.Accenture.countriesassignment.service.filter.SingleFilter;
import com.Accenture.countriesassignment.service.sorter.Sorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	@Autowired
	@Qualifier("filterInAsiaByAmountOfBordersNotInAsia")
	private SingleFilter filter;

	@Autowired
	@Qualifier("sortByPopulationDensityDesc")
	private Sorter sorter;

	@Override
	public void run(String...args) {

		service.filterCountries(filter);
		service.sortCounties(sorter);
	}

}
