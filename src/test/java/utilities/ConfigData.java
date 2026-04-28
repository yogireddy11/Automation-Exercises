package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigData {

    public static Properties properties;
    public static FileInputStream inputStream;

     static {
        try{
            properties = new Properties();
            inputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(inputStream);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getConfig(String key){
        return properties.getProperty(key);
    }
}
