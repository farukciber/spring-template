package ba.klika.springtemplate.controller;

import ba.klika.springtemplate.model.api.Country;
import ba.klika.springtemplate.model.api.CountryInfo;
import ba.klika.springtemplate.service.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountriesController {

    @Autowired
    private CountryServiceImpl countryService;

    @RequestMapping("/countries")
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }

    @RequestMapping("/countries/{countryId}")
    public CountryInfo getCountry(@PathVariable("countryId") String countryId) {
        return countryService.getCountryInfo(countryId);
    }
}
