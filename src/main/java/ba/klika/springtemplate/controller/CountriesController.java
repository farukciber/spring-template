package ba.klika.springtemplate.controller;

import ba.klika.springtemplate.exception.CountryNotFoundException;
import ba.klika.springtemplate.model.api.Country;
import ba.klika.springtemplate.model.api.CountryInfo;
import ba.klika.springtemplate.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CountriesController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Country>> getCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @RequestMapping(value = "/countries/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryInfo> getCountry(@PathVariable("countryId") String countryId) {
        try {
            return ResponseEntity.ok(countryService.getCountryInfo(countryId));
        } catch(CountryNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found", ex);
        }
    }
}
