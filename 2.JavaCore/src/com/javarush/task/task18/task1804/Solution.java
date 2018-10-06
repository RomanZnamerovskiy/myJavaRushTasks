package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.*;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();
        sc.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int value = 0, count = 0;
        while (fileInputStream.available() > 0) {
            value  = fileInputStream.read();
            if (map.containsKey(value)) {
                count = map.get(value) + 1;
                map.put(value, count);
            } else
                map.put(value, 0);
        }
        fileInputStream.close();

        int minCount = Integer.MAX_VALUE;
        for(Integer i : map.values()) {
            if (minCount > i) {
                minCount = i;
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if ( entry.getValue() == minCount) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
