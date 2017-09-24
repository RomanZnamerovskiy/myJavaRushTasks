package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(5.6, "aaa");
        labels.put(6.2, "bbb");
        labels.put(7.2, "ccc");
        labels.put(8.2, "ddd");
        labels.put(9.2, "eee");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
