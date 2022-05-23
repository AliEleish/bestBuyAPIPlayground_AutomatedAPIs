package restwrapper;

import DataReaders.readPropertiesFile;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;
public class restWrapper {


    public static <T> T restGetAsPOJO(String propertiesFilePath, String propertyKey,
                                      String APIPath, Class<T> responseClass) throws IOException {

        Properties baseURLProp = readPropertiesFile.getPropertiesFile(propertiesFilePath);
        String ApiBaseURL = baseURLProp.getProperty(propertyKey);
        restGet(propertiesFilePath, propertyKey, APIPath);

        return given().when().get(ApiBaseURL + APIPath).as(responseClass);
    }

    private static void restGet(String propertiesFilePath, String propertyKey,
                                String APIPath) throws IOException {

        Properties baseURLProp = readPropertiesFile.getPropertiesFile(propertiesFilePath);
        String ApiBaseURLValue = baseURLProp.getProperty(propertyKey);
        given().when().get(ApiBaseURLValue + APIPath).then().assertThat().statusCode(200).log().body();
        System.out.println("Status code is 200");
    }

    public static void restPostAsPOJO(String propertiesFilePath, String propertyKey, String ApiPath, Object ApiBodyObject)
            throws IOException {
        Properties baseURLProp = readPropertiesFile.getPropertiesFile(propertiesFilePath);
        String ApiBaseURLValue = baseURLProp.getProperty(propertyKey);
        given().body(ApiBodyObject).when().post(ApiBaseURLValue + ApiPath).then().assertThat().statusCode(200).log().body();

    }
}