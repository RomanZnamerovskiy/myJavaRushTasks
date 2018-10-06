package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName1 = sc.next();
        String fileName2 = sc.next();

        FileInputStream f1 = new FileInputStream(fileName1);
        FileOutputStream f2 = new FileOutputStream(fileName2);

        byte[] buf = new byte[f1.available()];
        f1.read(buf);

        for (int i = buf.length - 1; i >= 0; i--) {
            f2.write(buf[i]);
        }

        f1.close();
        f2.close();
    }
}
