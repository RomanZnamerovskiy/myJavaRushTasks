package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();

        FileInputStream file = new FileInputStream(fileName);

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        while(file.available() > 0) {
            Integer byteValue = file.read();
            if (map.containsKey(byteValue)) {
                int i = map.get(byteValue) + 1;
                map.put(byteValue, i);
            } else map.put(byteValue, 0);
        }

        int maxTimes = Integer.MIN_VALUE;
        for (Integer i2: map.values()) {
            if (maxTimes < i2)
                maxTimes = i2;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxTimes)) {
                System.out.print(entry.getKey() + " ");
            }
        }

        file.close();

    }
}
