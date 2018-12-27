package ba.klika.springtemplate.controller;

import ba.klika.springtemplate.exception.CountryNotFoundException;
import ba.klika.springtemplate.model.api.Country;
import ba.klika.springtemplate.model.api.CountryInfo;
import ba.klika.springtemplate.service.CountryService;
import ba.klika.springtemplate.service.CountryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(CountriesController.class)
@AutoConfigureMockMvc(secure = false)
@ContextConfiguration(classes = {CountryServiceImpl.class, CountriesController.class})
public class CountriesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Test
    public void getCountries_success() throws Exception {

        when(countryService.getAllCountries()).thenReturn(getMockedCountries());
        mockMvc.perform(get("/countries")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getCountry_success() throws Exception {
        String countryId = "1b9fbc34-6fed-4987-a3fd-eb2c5fdc3486";
        when(countryService.getCountryInfo(countryId)).thenReturn(getMockedCountry());
        mockMvc.perform(get("/countries/" + countryId)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getCountry_notFound() throws Exception {
        String countryId = "1b9fbc34-6fed-4987-a3fd-eb2c5fdc3486";
        when(countryService.getCountryInfo(countryId)).thenThrow(CountryNotFoundException.class);
        mockMvc.perform(get("/countries/" + countryId)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private List<Country> getMockedCountries() {
        List<Country> countries = new ArrayList<>();

        Country country = new Country();

        country.setId(UUID.randomUUID().toString());
        country.setIsoCode("BA");
        country.setName("Bosnia and Herzegovina");

        countries.add(country);

        country.setId(UUID.randomUUID().toString());
        country.setIsoCode("SEN");
        country.setName("Senegal");

        countries.add(country);

        return countries;
    }

    private CountryInfo getMockedCountry() {
        CountryInfo countryInfo = new CountryInfo();

        countryInfo.setName("Bosnia and Herzegovina");

        return countryInfo;
    }
}
