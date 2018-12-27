package ba.klika.springtemplate.connector.apilayer.restcountries.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
    http://www.jsonschema2pojo.org/
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acronym",
    "name",
    "otherAcronyms",
    "otherNames"
})
public class RegionalBloc {

    @JsonProperty("acronym")
    private String acronym;
    @JsonProperty("name")
    private String name;
    @JsonProperty("otherAcronyms")
    private List<Object> otherAcronyms = null;
    @JsonProperty("otherNames")
    private List<Object> otherNames = null;

    @JsonProperty("acronym")
    public String getAcronym() {
        return acronym;
    }

    @JsonProperty("acronym")
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("otherAcronyms")
    public List<Object> getOtherAcronyms() {
        return otherAcronyms;
    }

    @JsonProperty("otherAcronyms")
    public void setOtherAcronyms(List<Object> otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
    }

    @JsonProperty("otherNames")
    public List<Object> getOtherNames() {
        return otherNames;
    }

    @JsonProperty("otherNames")
    public void setOtherNames(List<Object> otherNames) {
        this.otherNames = otherNames;
    }
}
