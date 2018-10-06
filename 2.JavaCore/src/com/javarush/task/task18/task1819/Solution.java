package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName1 = sc.next(), fileName2 = sc.next();
        sc.close();

        FileInputStream f1 = new FileInputStream(fileName1);
        byte[] buf = new byte[f1.available()];
        f1.read(buf);
        f1.close();

        FileInputStream f2 = new FileInputStream(fileName2);
        byte[] buf2 = new byte[f2.available()];
        f2.read(buf2);
        f2.close();

        FileOutputStream f3 = new FileOutputStream(fileName1);
        f3.write(buf2);
        f3.close();

        FileOutputStream f4 = new FileOutputStream(fileName1, true);
        f4.write(buf);
        f4.close();

    }
}
