package Utils;

import Enums.Endpoints;
import Models.ResponseModels.categoriesAPIResponseModel;
import Restwrapper.queryParams;
import Restwrapper.restWrapper;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public  class CategoriesAPIUtils {

    public static categoriesAPIResponseModel getCategoriesResponseWithStatusCode200(String propertiesFilePath
            , String baseAPIPropertyKey , Endpoints APIUrl, Class responseClass) throws IOException {
       return  (categoriesAPIResponseModel)restWrapper.restGetAsPOJO( propertiesFilePath,baseAPIPropertyKey,APIUrl
               , responseClass);

    }

   public static categoriesAPIResponseModel getCategoryWithSpecificID(String IDParamValue) throws IOException {
       return  restWrapper.restGetWithParams("src/main/resources/Properties/baseURL.properties", "ApiBaseURL",
                 queryParams.getQueryParams(IDParamValue), Endpoints.CATEGORIES,categoriesAPIResponseModel.class)  ;
   }

}
