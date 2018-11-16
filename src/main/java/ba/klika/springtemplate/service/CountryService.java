package ba.klika.springtemplate.service;

import ba.klika.springtemplate.model.api.Country;
import ba.klika.springtemplate.model.api.CountryInfo;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();

    CountryInfo getCountryInfo(String countryId);
}
