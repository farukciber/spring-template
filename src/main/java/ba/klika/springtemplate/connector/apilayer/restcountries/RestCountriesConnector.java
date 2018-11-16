package ba.klika.springtemplate.connector.apilayer.restcountries;

import ba.klika.springtemplate.connector.apilayer.restcountries.model.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "apilayer-restcountries", url = "https://restcountries.eu/rest/v2")
public interface RestCountriesConnector {

    @RequestMapping(method = RequestMethod.GET, value = "/alpha/{code}")
    Country getCountryByISOCode(@PathVariable("code") String code);
}
