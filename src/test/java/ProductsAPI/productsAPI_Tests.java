package ProductsAPI;

import Models.ResponseModels.productsAPIResponseModel;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import restwrapper.restWrapper;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class productsAPI_Tests {


    public productsAPI_Tests(){
    }

    @Test
    public void TC01_CheckAllProductAreRetrievedSuccessfully() throws IOException {

        productsAPIResponseModel response =  restWrapper.restGetAsPOJO("src/main/resources/Properties/baseURL.properties"
                , "ApiBaseURL" , "/products" , productsAPIResponseModel.class);


       Assert.assertThat(response.total , equalTo(51957));
       Assert.assertThat(response.limit , equalTo(10));
       Assert.assertThat(response.skip , equalTo(0));
       Assert.assertThat(response.data.size() , equalTo(10));
       for(int i=0 ; i<response.data.size() ; i++)
       {
           Assert.assertThat(response.data.get(i).id , notNullValue());
           Assert.assertThat(response.data.get(i).name ,notNullValue());
           Assert.assertThat(response.data.get(i).type ,notNullValue());
           Assert.assertThat(response.data.get(i).price ,notNullValue());
           Assert.assertThat(response.data.get(i).upc ,notNullValue());
           Assert.assertThat(response.data.get(i).shipping ,notNullValue());
           Assert.assertThat(response.data.get(i).description ,notNullValue());
           Assert.assertThat(response.data.get(i).manufacturer ,notNullValue());
           Assert.assertThat(response.data.get(i).model ,notNullValue());
           Assert.assertThat(response.data.get(i).url ,notNullValue());
           Assert.assertThat(response.data.get(i).image ,notNullValue());
           Assert.assertThat(response.data.get(i).createdAt ,notNullValue());
           Assert.assertThat(response.data.get(i).updatedAt ,notNullValue());
           for (int j=0 ; j< response.data.get(i).categories.size() ; j++)
           {
               Assert.assertThat(response.data.get(i).categories.get(j).id , notNullValue());
               Assert.assertThat(response.data.get(i).categories.get(j).name , notNullValue());
               Assert.assertThat(response.data.get(i).categories.get(j).createdAt , notNullValue());
               Assert.assertThat(response.data.get(i).categories.get(j).updatedAt , notNullValue());
           }
       }



    }
}
