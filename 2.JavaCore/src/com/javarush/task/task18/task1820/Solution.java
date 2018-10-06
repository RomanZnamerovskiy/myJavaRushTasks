package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bf.readLine();
        String fileName2 = bf.readLine();
        bf.close();


        ArrayList<String> list = new ArrayList<String>();
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        byte[] b = new byte[fileInputStream.available()];
        fileInputStream.read(b);

        String temp = new String(b);
        for (String z : temp.split(" ")) {
            float x = Float.parseFloat(z);
            list.add(Math.round(x) + " ");
        }

        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        for (String h: list) {
            fileOutputStream.write(h.getBytes());
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
