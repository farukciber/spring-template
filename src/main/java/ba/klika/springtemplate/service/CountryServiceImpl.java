package ba.klika.springtemplate.service;

import ba.klika.springtemplate.database.DbCountryService;
import ba.klika.springtemplate.exception.CountryNotFoundException;
import ba.klika.springtemplate.model.api.Country;
import ba.klika.springtemplate.model.api.CountryInfo;
import ba.klika.springtemplate.service.apilayer.RestCountriesConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private RestCountriesConnectorService restCountriesConnectorService;

    @Autowired
    private DbCountryService dbCountryService;

    @Override
    public List<Country> getAllCountries() {
        return dbCountryService.getAllCountries();
    }

    @Override
    public CountryInfo getCountryInfo(String countryId) {
        Optional<Country> countryOptional = dbCountryService.getCountryById(countryId);

        Country country = countryOptional.orElseThrow(CountryNotFoundException::new);

        return restCountriesConnectorService.getCountryByISOCode(country.getIsoCode());
    }
}
