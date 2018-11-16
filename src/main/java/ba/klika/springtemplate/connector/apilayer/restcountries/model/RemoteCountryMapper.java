package ba.klika.springtemplate.connector.apilayer.restcountries.model;

import ba.klika.springtemplate.model.api.CountryInfo;
import org.springframework.stereotype.Component;

@Component
public class RemoteCountryMapper {

    public CountryInfo mapToApi(Country country) {
        CountryInfo countryInfo = new CountryInfo();

        countryInfo.setSubregion(country.getSubregion());
        countryInfo.setRegion(country.getRegion());
        countryInfo.setPopulation(country.getPopulation());
        countryInfo.setCallingCodes(country.getCallingCodes());
        countryInfo.setAltSpellings(country.getAltSpellings());
        countryInfo.setName(country.getName());
        countryInfo.setIsoCode(country.getAlpha3Code());
        countryInfo.setCapital(country.getCapital());

        return countryInfo;
    }
}
