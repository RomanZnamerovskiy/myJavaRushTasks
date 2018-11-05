package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String[] line = reader.readLine().split(" ");
            String name = line[0];
            Double value = Double.parseDouble(line[1]);

            if (map.containsKey(name)) {
                map.put(name, map.get(name) + value);
            } else {
                map.put(name, value);
            }
        }
        reader.close();

        double maxDouble = Double.MIN_VALUE;
        for (Double d : map.values()) {
            if (maxDouble < d) {
                maxDouble = d;
            }
        }

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() == maxDouble) {
                System.out.println(entry.getKey());
            }
        }

    }
}
