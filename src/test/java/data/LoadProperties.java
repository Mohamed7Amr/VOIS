package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {


    public static Properties userData;

    static {
        try {
            userData = loadProperties("src/main/java/properties/userData.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static Properties loadProperties(String filePath) throws IOException {
        Properties pro = new Properties();

        FileInputStream stream = new FileInputStream(filePath);
        pro.load(stream);
        return pro;
    }



}
