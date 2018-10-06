package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName1 =  sc.next();
        String fileName2 = sc.next();
        String fileName3 = sc.next();

        try {
            FileInputStream fInput = new FileInputStream(fileName1);
            FileOutputStream fOutput2 = new FileOutputStream(fileName2);
            FileOutputStream fOutput3 = new FileOutputStream(fileName3);

            int fileSize = fInput.available();
            int part1Size = fileSize % 2 == 0 ? fileSize / 2 : fileSize / 2 + 1;


            while (fInput.available() > 0) {
                byte[] buf1 = new byte [part1Size];
                byte[] buf2 = new byte [fileSize - part1Size];

                fInput.read(buf1);
                fInput.read(buf2);
                fOutput2.write(buf1);
                fOutput3.write(buf2);
            }

            fInput.close();
            fOutput2.close();
            fOutput3.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
