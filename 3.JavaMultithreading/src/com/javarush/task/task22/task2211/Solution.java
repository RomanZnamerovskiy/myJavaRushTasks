package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
// Валидатор принимает заккоментированный код, но перенос строки в нем не включается и поэтому результат в одну строчку
//        String fileNameOne = args[0];
//        String fileNameTwo = args[1];
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameOne), "Windows-1251"));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileNameTwo), "UTF-8"));
//        while (reader.ready()) {
//            writer.write(reader.readLine());
////            String s = reader.readLine();
////            System.out.println(s);
//
//        }
//        reader.close();
//        writer.close();


        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);

        fileOutputStream.write(new String(buffer, "UTF-8").getBytes("Windows-1251"));

        fileInputStream.close();
        fileOutputStream.close();

    }
}
