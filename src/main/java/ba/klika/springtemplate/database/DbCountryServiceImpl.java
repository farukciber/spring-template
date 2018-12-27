package ba.klika.springtemplate.database;

import ba.klika.springtemplate.database.dao.CountryDAO;
import ba.klika.springtemplate.database.model.DbCountry;
import ba.klika.springtemplate.database.model.DbCountryMapper;
import ba.klika.springtemplate.model.api.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DbCountryServiceImpl implements DbCountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Autowired
    private DbCountryMapper countryMapper;

    @Override
    public List<Country> getAllCountries() {
        Iterable<DbCountry> dbCountries = countryDAO.findAll();

        return StreamSupport.stream(dbCountries.spliterator(), false)
                .map(countryMapper::maptoApi)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Country> getCountryById(String id) {
        Optional<DbCountry> dbCountryOptional = countryDAO.findById(id);

        return dbCountryOptional.map(countryMapper::maptoApi);
    }
}
