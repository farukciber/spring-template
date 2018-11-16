package ba.klika.springtemplate.service.mapper;

import ba.klika.springtemplate.database.model.DbCountry;
import ba.klika.springtemplate.model.api.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {
    public Country mapDbToApi(DbCountry dbCountry) {
        Country country = new Country();
        country.setId(dbCountry.getId());
        country.setIsoCode(dbCountry.getIsoCode());
        country.setName(dbCountry.getName());
        return country;
    }
}
