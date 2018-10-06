package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String fileName1 = sc.next(), fileName2 = sc.next(), fileName3 = sc.next();

        FileWriter f1 = new FileWriter(fileName1);
        FileReader f2 = new FileReader(fileName2);
        FileReader f3 = new FileReader(fileName3);

        while (f2.ready()) {
            char c = (char) f2.read();
            f1.append(c);
        }

        while (f3.ready()) {
            char c = (char) f3.read();
            f1.append(c);
        }

        f1.close();
        f2.close();
        f3.close();

    }
}
