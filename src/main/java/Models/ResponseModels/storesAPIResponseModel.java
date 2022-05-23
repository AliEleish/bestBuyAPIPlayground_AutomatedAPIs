package Models.ResponseModels;

import Models.RequestModels.StoresAPIRequestModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name" , "type" , "address" , "address2" , "city", "state" , "zip" , "lat" , "lng" , "hours" , "services" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class storesAPIResponseModel {
    @JsonProperty("name")
    public String name;
    @JsonProperty("type")
    public String type;
    @JsonProperty("address")
    public String address;
    @JsonProperty("address2")
    public String address2;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("zip")
    public String zip;
    @JsonProperty("lat")
    public int lat;
    @JsonProperty("lng")
    public int lng;
    @JsonProperty("hours")
    public String hours;
    @JsonProperty("services")
    public StoresAPIRequestModel.Services services;

    public class Services {
    }
}
