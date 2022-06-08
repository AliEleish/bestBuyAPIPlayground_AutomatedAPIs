package CategoriesAPI;

import Enums.Endpoints;
import Models.ResponseModels.categoriesAPIResponseModel;
import Utils.CategoriesAPIUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class categoriesAPITests {

    @Test
    public void getAllCategories() throws IOException {
        CategoriesAPIUtils.getCategoriesResponseWithStatusCode200("src/main/resources/Properties/baseURL.properties"
                , "ApiBaseURL", Endpoints.CATEGORIES, categoriesAPIResponseModel.class);
    }

    @Test
    public void getCategoryWithSpecificId() throws IOException {

        categoriesAPIResponseModel categoriesResponseObj = CategoriesAPIUtils.getCategoryWithSpecificID("abcat0020001");
        Assert.assertEquals(categoriesResponseObj.data.get(0).id, "abcat0020001");
        Assert.assertEquals(categoriesResponseObj.data.get(0).name, "Learning Toys");
    }
}