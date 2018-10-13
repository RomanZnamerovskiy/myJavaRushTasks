package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);
        int count = 1;
        while (fileReader.ready()) {
            int i = fileReader.read();
            if (count % 2 == 0) {
                fileWriter.write(i);
            }
            count++;
        }
        fileReader.close();
        fileWriter.close();
    }
}
