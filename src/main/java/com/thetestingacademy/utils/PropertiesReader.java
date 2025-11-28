package com.thetestingacademy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    //Read the data.properties file and give it to anyone who wants with key
    // For ex: if we give key like url: It will give its corresponding value or data: https://app.vwo.com

    public static String readKey(String key){
        Properties p;
        String user_dir = System.getProperty("user.dir");
        String file_path = user_dir + "/src/main/resources/data.properties";

        try {
            FileInputStream fileInputStream = new FileInputStream(file_path); // Open the file
            p = new Properties();
            p.load(fileInputStream); // Load the file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return p.getProperty(key); // returns the corresponding value of the key
    }
}
