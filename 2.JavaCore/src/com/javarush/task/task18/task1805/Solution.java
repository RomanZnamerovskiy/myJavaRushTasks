package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        Set<Integer> set = new TreeSet<>();
        while (fileInputStream.available() > 0) {
            set.add(fileInputStream.read());
        }

        fileInputStream.close();

        for (int i : set) {
            System.out.print(i + " ");
        }
    }
}
