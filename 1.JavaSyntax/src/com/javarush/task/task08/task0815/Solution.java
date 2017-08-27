package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> list = new HashMap<String, String>();
        list.put("Roma1", "Znamer1");
        list.put("Roma1", "Znamer1");
        list.put("Roma2", "Znamer2");
        list.put("Roma3", "Znamer3");
        list.put("Roma4", "Znamer4");
        list.put("Roma5", "Znamer5");
        list.put("Roma6", "Znamer6");
        list.put("Roma6", "Znamer6");
        list.put("Roma6", "Znamer6");
        list.put("Roma6", "Znamer6");

        return list;

    }


    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for(Map.Entry<String, String> pair : map.entrySet()){
            if(pair.getKey().equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for(Map.Entry<String, String> pair : map.entrySet()){
            if(pair.getValue().equals(lastName)) count++;
        }
        return count;

    }

    public static void main(String[] args) {

    }
}
