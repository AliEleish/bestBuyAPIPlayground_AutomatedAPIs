package Models.ResponseModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"total", "limit" , "skip" , "data"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class productsAPIResponseModel {

    @JsonProperty("total")
    public  int total;
    @JsonProperty("limit")
    public  int limit;
    @JsonProperty("skip")
    public  int skip;
    @JsonProperty("data")
    public  ArrayList<Data> data;

    public static class Data{
        public int id;
        public String name;
        public String type;
        public double price;
        public String upc;
        public int shipping;
        public String description;
        public String manufacturer;
        public String model;
        public String url;
        public String image;
        public Date createdAt;
        public Date updatedAt;
        public ArrayList<Category> categories;
    }
    public static class Category{
        public String id;
        public String name;
        public Date createdAt;
        public Date updatedAt;
    }

}
