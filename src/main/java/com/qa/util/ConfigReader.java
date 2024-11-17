package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    // Initialize properties
    public Properties initProperties() {
        prop = new Properties();
        try {
            FileInputStream input = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
