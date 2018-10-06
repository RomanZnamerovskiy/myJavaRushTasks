package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        int countTotal = 0, countSpaces = 0;

        FileReader f = new FileReader(fileName);
        while (f.ready()) {
            char ch = (char) f.read();
            countTotal++;
            if (ch == ' ') {
                countSpaces++;
            }

        }

        f.close();

        double d = (countSpaces * 1.0) / countTotal * 100;

        System.out.printf("%.2f", d);
    }
}
