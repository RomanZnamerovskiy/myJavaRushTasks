package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();

        InputStream inStream = new FileInputStream(s);

        while (inStream.available() > 0)
        {
            int i = inStream.read();
            System.out.print((char) i);
        }
        System.out.println();

        inStream.close();

    }
}