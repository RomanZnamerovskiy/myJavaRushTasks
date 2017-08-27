package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

/*
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Surname1", "Name1");
        map.put("Surname2", "Name1");
        map.put("Surname3", "Name2");
        map.put("Surname4", "Name2");
        map.put("Surname5", "Name3");
        map.put("Surname6", "Name2");
        map.put("Surname7", "Name5");
        map.put("Surname8", "Name6");
        map.put("Surname9", "Name6");
        map.put("Surname10", "Name1");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>(map.values());


        for(String s: list) {
            int i = Collections.frequency(list, s);
            if ( i > 1) removeItemFromMapByValue(map, s);
        }
//
//        ArrayList<String> list = new ArrayList<>();
//
//        for(HashMap.Entry<String, String> pair : map.entrySet()) {
//            int i = 0;
//            for(HashMap.Entry<String, String> pair2 : map.entrySet()) {
//
//                if (pair.getValue().equals(pair2.getValue())) {
//                    i++;
//                }
//                if (i > 1) {
//                    list.add(pair.getValue());
//                }
//            }
//
//
//            }
//
//        for(int i2 = 0; i2 < list.size(); i2++) {
//            removeItemFromMapByValue(map, list.get(i2));
//        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
    HashMap<String, String> map = createMap();
    removeTheFirstNameDuplicates(map);

    }
}
