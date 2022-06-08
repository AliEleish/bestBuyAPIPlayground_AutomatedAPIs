package Models.ResponseModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class categoriesAPIResponseModel {

        public int total;
        public int limit;
        public int skip;
        public ArrayList<Data> data;

    public static class Data{
        public String id;
        public String name;
        public String createdAt;
        public String updatedAt;
        public ArrayList<SubCategories> subCategories;
        public ArrayList<CategoryPath> categoryPath;
    }

    public static class CategoryPath{
        public String id;
        public String name;
        public String createdAt;
        public String updatedAt;
    }

    public static class SubCategories{

    }


}
