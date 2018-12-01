package com.javarush.task.task22.task2210;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        for (String s: getTokens("level22.lesson13.task01", ".")) {
            System.out.println(s);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List<String> list = new LinkedList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        String[] arr = new String[list.size()];
        return  list.toArray(arr);
    }
}
