package ba.klika.springtemplate.service.apilayer;

import ba.klika.springtemplate.connector.apilayer.restcountries.RestCountriesConnector;
import ba.klika.springtemplate.connector.apilayer.restcountries.model.Country;
import ba.klika.springtemplate.connector.apilayer.restcountries.model.RemoteCountryMapper;
import ba.klika.springtemplate.exception.CountryNotFoundException;
import ba.klika.springtemplate.exception.InvalidISOCodeException;
import ba.klika.springtemplate.exception.ServiceUnavailableException;
import ba.klika.springtemplate.model.api.CountryInfo;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestCountriesConnectorService {

    @Autowired
    private RestCountriesConnector restCountriesConnector;

    @Autowired
    private RemoteCountryMapper remoteCountryMapper;

    public CountryInfo getCountryByISOCode(String isoCode) {
        try {
            Country remoteCountry = restCountriesConnector.getCountryByISOCode(isoCode);

            return remoteCountryMapper.mapToApi(remoteCountry);
        }
        catch (FeignException ex) {
            if (ex.status() == 404) {
                throw new CountryNotFoundException();
            }
            else if (ex.status() == 400) {
                throw new InvalidISOCodeException();
            }
            else {
                throw new ServiceUnavailableException();
            }
        }
    }
}
