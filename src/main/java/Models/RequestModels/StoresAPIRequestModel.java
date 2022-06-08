package Models.RequestModels;

import Models.ResponseModels.storesAPIResponseModel;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoresAPIRequestModel {
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
    public double lat;
    @JsonProperty("lng")
    public double lng;
    @JsonProperty("hours")
    public String hours;
    @JsonProperty("Services")
    public Services services;

    public class Services {

        public Services()
        {

        }
    }


    public StoresAPIRequestModel()
    {

    }


    public StoresAPIRequestModel(String name , String type , String address , String address2 , String city , String state ,
    String zip , double lat ,  double lng , String hours ,Services services )
    {

        setName(name);
        setType(type);
        setAddress(address);
        setAddress2(address2);
        setCity(city);
        setState(state);
        setZip(zip);
        setLat(lat);
        setLng(lng);
        setHours(hours);
        setServices(services);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}



