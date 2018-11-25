package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
//        if (string ==  null || string.isEmpty()) throw new TooShortStringException();
//        int indexOfFirstSpace = string.indexOf(" ");
//        int indexOfForthSpace = -1;
//        for (int i = 0; i < 4; i++) {
//            indexOfForthSpace = string.indexOf(" ", (indexOfForthSpace + 1));
//        }
//        if (indexOfFirstSpace == -1 || indexOfForthSpace == -1) {
//            throw new TooShortStringException();
//        }
//
//        int indexOfFifthSpace = string.indexOf(" ", indexOfForthSpace + 1);
//        if (indexOfFifthSpace == -1) {
//            return string.substring(indexOfFirstSpace + 1);
//        }
//        return string.substring(indexOfFirstSpace + 1, indexOfFifthSpace);
        if (string ==  null || string.isEmpty())
            throw new TooShortStringException();

        String[] s = string.split(" ");
        if (s.length < 5)
            throw new TooShortStringException();

        return s[1] + " " + s[2] + " " + s[3] + " " + s[4];


    }

    public static class TooShortStringException extends RuntimeException {
    }
}
