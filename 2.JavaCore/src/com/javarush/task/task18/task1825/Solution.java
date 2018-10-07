package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> parts = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (true) {
            fileName = reader.readLine();
            if (fileName.equals("end")) {
                break;
            } else parts.add(fileName);
        }
        reader.close();

        //Sort collection
        Collections.sort(parts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //Output stream
        String outputFileName = parts.get(0).split(".part")[0];
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
        FileInputStream fileInputStream = null;
        for (String partsFileNames : parts) {
            fileInputStream = new FileInputStream(partsFileNames);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}
