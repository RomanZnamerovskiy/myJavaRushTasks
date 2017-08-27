package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date d = new Date(date);
        Date a = new Date();
        a.setMonth(0);
        a.setDate(1);
        a.setHours(0);
        a.setYear(d.getYear());
        long pastMiliseconds = d.getTime() - a.getTime();
        int pastDays = (int) (pastMiliseconds/(24*60*60*1000));
        return pastDays % 2 != 0;
    }
}
