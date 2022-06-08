package StoresAPI;

import Enums.Endpoints;
import Models.RequestModels.StoresAPIRequestModel;
import Models.ResponseModels.storesAPIResponseModel;
import Restwrapper.restWrapper;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StoresAPI_Tests {

    @Test
    public void getAllStores() throws IOException {
        restWrapper.restGetAsPOJO("src/main/resources/Properties/baseURL.properties" , "ApiBaseURL",
                Endpoints.STORES, storesAPIResponseModel.class);
    }

    @Test
    public void TC02_CheckWhenUserCreateNewStoreSuccessfully() throws IOException {
        StoresAPIRequestModel storesApiRequestModelObj1 = new StoresAPIRequestModel();
        StoresAPIRequestModel.Services services =  storesApiRequestModelObj1.new Services();
        StoresAPIRequestModel storesApiRequestModelObj2 = new StoresAPIRequestModel("Millennials Shop" , "Accessories",
                "11334 Wall Street" , "" , "New York City" , "New York", "10009" , 55.786545
        , -40.786543, "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8", services );
        restWrapper.restPostAsPOJO("src/main/resources/Properties/baseURL.properties" , "ApiBaseURL",
                "/stores" ,storesApiRequestModelObj2, storesAPIResponseModel.class);
    }

    @Test
    public void getStoreWithId()
    {
        String endPoint = "http://localhost:3030/stores";
        given().queryParam("id","6").when().get(endPoint).then().assertThat().statusCode(200).log().body();

    }


}
