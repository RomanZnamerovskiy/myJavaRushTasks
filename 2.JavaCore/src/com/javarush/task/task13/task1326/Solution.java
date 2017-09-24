package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader reader3 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        ArrayList<Integer> list = new ArrayList<>();
        while (reader3.ready()) {
            String s = reader3.readLine();
            int i;
            if (!s.isEmpty()) {
                 i = Integer.parseInt(s);
            } else continue;
            if (i % 2 == 0) list.add(i);
        }

        Collections.sort(list);

        for(int i : list) {
            System.out.println(i);
        }

        reader3.close();
    }
}
