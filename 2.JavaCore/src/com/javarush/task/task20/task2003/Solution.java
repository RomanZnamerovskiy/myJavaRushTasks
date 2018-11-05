package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);
        fileInputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties propertiesFile = new Properties();
        for(Map.Entry<String, String> mapEntry: properties.entrySet()) {
            propertiesFile.setProperty(mapEntry.getKey(), mapEntry.getValue());
        }
        propertiesFile.store(outputStream, "bla bla");
        outputStream.close();

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties propertiesFile = new Properties();
        propertiesFile.load(inputStream);
        for (String propertyName: propertiesFile.stringPropertyNames()) {
            String property = propertiesFile.getProperty(propertyName);
            properties.put(propertyName, property);
        }
        inputStream.close();

    }

    public static void main(String[] args) {

    }
}
