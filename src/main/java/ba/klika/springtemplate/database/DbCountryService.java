package ba.klika.springtemplate.database;

import ba.klika.springtemplate.model.api.Country;

import java.util.List;
import java.util.Optional;

public interface DbCountryService {

    List<Country> getAllCountries();

    Optional<Country> getCountryById(String id);
}
