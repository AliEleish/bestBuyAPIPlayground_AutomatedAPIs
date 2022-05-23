package DataReaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readPropertiesFile {

    private static FileInputStream fis;
    private static Properties propFileObj;

    public static Properties getPropertiesFile(String filePath) throws IOException {

        try {
            fis = new FileInputStream(filePath);
            propFileObj = new Properties();
            propFileObj.load(fis);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return propFileObj;
    }
}
