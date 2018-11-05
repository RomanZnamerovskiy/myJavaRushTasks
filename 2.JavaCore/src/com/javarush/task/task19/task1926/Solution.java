package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while(fileReader.ready()) {
            String line = fileReader.readLine();
            char[] chars = line.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }

        fileReader.close();
    }
}
