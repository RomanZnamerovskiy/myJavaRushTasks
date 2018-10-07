package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        byte[] bytes;
        switch (args[0]) {
            case "-e" :
                bytes = new byte[fileInputStream.available()];
                fileInputStream.read(bytes);
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte)(bytes[i] + 6);
                }
                fileOutputStream.write(bytes);
                break;
            case "-d" :
                bytes = new byte[fileInputStream.available()];
                fileInputStream.read(bytes);
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = (byte)(bytes[i] - 6);
                }
                fileOutputStream.write(bytes);
                break;
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

}
