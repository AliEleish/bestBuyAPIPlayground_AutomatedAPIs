package Restwrapper;

import java.util.HashMap;
import java.util.Map;

public class queryParams {



 public static Map<String,String> getQueryParams(String queryParamVal)
 {
     Map<String,String> queryParams = new HashMap<>();
     queryParams.put("id",queryParamVal);
     return queryParams;
 }
}
