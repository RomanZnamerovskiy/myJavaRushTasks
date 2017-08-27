package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Surname1", 400);
        map.put("Surname2", 600);
        map.put("Surname3", 300);
        map.put("Surname4", 700);
        map.put("Surname5", 100);
        map.put("Surname6", 900);
        map.put("Surname7", 300);
        map.put("Surname8", 200);
        map.put("Surname9", 300);
        map.put("Surname10", 100);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            int value = pair.getValue();
            if(value < 500) iterator.remove();
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        Solution.removeItemFromMap(map);

    }
}