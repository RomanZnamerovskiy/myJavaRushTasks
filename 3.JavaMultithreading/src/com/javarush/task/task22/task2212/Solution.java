package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) {
            return false;
        }

        Pattern pattern = Pattern.compile("(^\\+\\d{2})?\\(?\\d{3}\\)?(\\d+-){0,2}\\d+");
        Matcher matcher = pattern.matcher(telNumber);
        boolean b = matcher.matches();
        return b;
    }

    public static void main(String[] args) {
        System.out.println("+380501234567 - " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567 - " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 - " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 - " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 - " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 - " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 - " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 - " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 - " + checkTelNumber("(0)501234567"));
    }
}
