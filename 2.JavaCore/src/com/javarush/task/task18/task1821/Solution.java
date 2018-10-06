package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<Byte, Integer> frequencymap = new TreeMap<Byte, Integer>();
        FileInputStream f = new FileInputStream(args[0]);

        while (f.available() > 0) {
            byte[] buf = new byte[f.available()];
            f.read(buf);

            for (int i = 0; i < buf.length; i++) {
                if (frequencymap.containsKey(buf[i]))
                    frequencymap.put(buf[i], frequencymap.get(buf[i]) + 1);
                else
                    frequencymap.put(buf[i], 1);
            }
        }
        f.close();

        for (Map.Entry pair : frequencymap.entrySet()) {
            System.out.println((char) ((byte) pair.getKey()) + " " + pair.getValue());
        }
    }
}

