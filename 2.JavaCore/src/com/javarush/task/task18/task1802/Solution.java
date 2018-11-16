package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String fileName = sc.next();
        FileInputStream fileReader = new FileInputStream(fileName);
        int min = 1000;
        while (fileReader.available() > 0) {
            int b = fileReader.read();
            if (min > b) {
                min = b;
            }
        }
        System.out.println(min);
        fileReader.close();
        sc.close();
    }
}
