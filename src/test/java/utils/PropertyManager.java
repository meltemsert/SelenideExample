package utils;

import java.io.*;
import java.util.Properties;

public class PropertyManager {

    Properties property;

    public PropertyManager() {
        Properties props = new Properties();
        try {
            props.load(new FileReader((ClassLoader.getSystemResource("config.properties").getPath())));
            property = props;
        } catch (IOException e) {
            System.out.println("Propeties file not found!");
        }
    }

    public String getProperty(String key) {
        Properties props = property;
        if (props != null) {
            return props.getProperty(key);
        }
        return null;
    }
}
