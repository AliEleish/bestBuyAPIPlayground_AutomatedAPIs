package StoresAPI;

import Models.RequestModels.StoresAPIRequestModel;
import Models.ResponseModels.storesAPIResponseModel;
import org.junit.jupiter.api.Test;
import restwrapper.restWrapper;

import java.io.IOException;
import java.util.Properties;

public class StoresAPI_Tests {

    @Test
    public void getAllStores() throws IOException {
        restWrapper.restGetAsPOJO("src/main/resources/Properties/baseURL.properties" , "ApiBaseURL",
                "/stores" , storesAPIResponseModel.class);
    }

    @Test
    public void TC02_CheckWhenUserCreateNewStoreSuccessfully() throws IOException {
        StoresAPIRequestModel storesApiRequestModelObj1 = new StoresAPIRequestModel();
        StoresAPIRequestModel.Services services =  storesApiRequestModelObj1.new Services();
        StoresAPIRequestModel storesApiRequestModelObj2 = new StoresAPIRequestModel("Millennials Shop" , "Accessories",
                "11334 Wall Street" , "" , "New York City" , "New York", "10009" , 55.786545
        , -40.786543, "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8", services);
        restWrapper.restPostAsPOJO("src/main/resources/Properties/baseURL.properties" , "ApiBaseURL",
                "/stores" ,storesApiRequestModelObj2);
    }
}
