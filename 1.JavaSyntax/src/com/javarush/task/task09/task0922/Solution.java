package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        SimpleDateFormat simple = new SimpleDateFormat("MM/dd/yyyy");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Date d = simple.parse(s);
        simple = new SimpleDateFormat("MMM dd, yyyy",  Locale.ENGLISH);
        System.out.println(simple.format(d).toUpperCase());
    }
}
