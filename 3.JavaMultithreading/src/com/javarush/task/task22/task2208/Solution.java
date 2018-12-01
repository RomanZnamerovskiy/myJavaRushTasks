package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("age", null);

        String s = getQuery(map);
        System.out.println(s);
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry: params.entrySet()) {
            if (entry.getValue() != null && ! entry.getValue().isEmpty()) {
                result.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' and ");
            }
        }
        if (result.length() > 5){
            result.delete(result.length() - 5, result.length());
        }
        return result.toString();
    }
}
