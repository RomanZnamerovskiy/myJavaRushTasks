package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        br.close();

        BufferedReader f = new BufferedReader(new FileReader(fileName1));

        while (f.ready()) {
            String s = f.readLine();
            if (s.startsWith(args[0]))
                System.out.println(s);
        }


        f.close();

    }
}
