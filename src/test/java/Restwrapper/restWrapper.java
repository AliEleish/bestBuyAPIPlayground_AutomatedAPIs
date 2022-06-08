package Restwrapper;

import DataReaders.readPropertiesFile;
import Enums.Endpoints;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;
public class restWrapper {

    public static <T> T restGetAsPOJO(String propertiesFilePath, String propertyKey,
                                      Endpoints APIPath, Class<T> responseClass) throws IOException {

        Properties baseURLProp = readPropertiesFile.getPropertiesFile(propertiesFilePath);
        String ApiBaseURL = baseURLProp.getProperty(propertyKey);
        restGet(propertiesFilePath, propertyKey, APIPath);

        return given().when().get(ApiBaseURL + APIPath.getUrl()).as(responseClass);
    }

    private static void restGet(String propertiesFilePath, String propertyKey,
                                Endpoints APIPath) throws IOException {

        Properties baseURLProp = readPropertiesFile.getPropertiesFile(propertiesFilePath);
        String ApiBaseURLValue = baseURLProp.getProperty(propertyKey);
        given().when().get(ApiBaseURLValue + APIPath.getUrl()).then().assertThat().statusCode(200).log().body();
        System.out.println("Status code is 200");
    }

    public static <T> T restPostAsPOJO(String propertiesFilePath, String propertyKey, String ApiPath, Object ApiBodyObject
            , Class<T> responseClass)
            throws IOException {
        Properties baseURLProp = readPropertiesFile.getPropertiesFile(propertiesFilePath);
        String ApiBaseURLValue = baseURLProp.getProperty(propertyKey);
        return given().body(ApiBodyObject).when().post(ApiBaseURLValue.concat(ApiPath)).as(responseClass);

    }

    public static <T> T restGetWithParams(String PropertiesFilePath , String baseURLPropertyKey , Map<String , String> pathParams
    , Endpoints ApiPath , Class<T> responseClass) throws IOException {
        Properties baseUrlPropertiesObj = readPropertiesFile.getPropertiesFile(PropertiesFilePath);
        String baseUrlEndpoint = baseUrlPropertiesObj.getProperty(baseURLPropertyKey);
       return given()
               .queryParams(pathParams)
               .when()
               .get(baseUrlEndpoint.concat(ApiPath.getUrl()))
               .then()
               .extract()
               .as(responseClass);
    }


}