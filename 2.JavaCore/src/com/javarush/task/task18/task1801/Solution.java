package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();

        FileInputStream fileReader = new FileInputStream(fileName);
        int maxByte = 0;
        while (fileReader.available() > 0) {
            int byteValue = fileReader.read();
            if (maxByte < byteValue) {
                maxByte = byteValue;
            }
        }
        System.out.println(maxByte);
        br.close();
        fileReader.close();
    }
}
