package ba.klika.springtemplate.database.dao;

import ba.klika.springtemplate.database.model.DbCountry;
import org.springframework.data.repository.CrudRepository;

public interface CountryDAO extends CrudRepository<DbCountry, String> {

}
