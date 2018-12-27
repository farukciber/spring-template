package ba.klika.springtemplate.database.model;

import ba.klika.springtemplate.model.api.Country;
import org.springframework.stereotype.Component;

@Component
public class DbCountryMapper {

    public Country maptoApi(DbCountry dbCountry) {
        Country country = new Country();

        country.setId(dbCountry.getId());
        country.setName(dbCountry.getName());
        country.setIsoCode(dbCountry.getIsoCode());

        return country;
    }
}
