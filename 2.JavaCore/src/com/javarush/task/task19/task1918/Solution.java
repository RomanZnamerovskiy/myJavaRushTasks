package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        String tag = args[0];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        Pattern pattern = Pattern.compile("<" + tag +".*>.*<//"+ tag + ">");
        Matcher matcher;
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}
