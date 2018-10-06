package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();

        int count = 0;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);

            while (fileInputStream.available() > 0) {
                char ch = (char) fileInputStream.read();
                if (ch == ',')
                    count++;
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found1");
        } catch (IOException e) {
            System.out.println("File " + fileName + " can't read");
        }

        System.out.println(count);


    }
}
