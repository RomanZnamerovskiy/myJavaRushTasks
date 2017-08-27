package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        char[] strChar = s.toCharArray();

        strChar[0] = Character.toUpperCase(strChar[0]);
        for(int i = 0; i < strChar.length - 1; i++) {
            if (Character.isWhitespace(strChar[i]))
                strChar[i + 1] = Character.toUpperCase(strChar[i + 1]);
        }

        s = String.copyValueOf(strChar);
        System.out.println(s);



//        char[] strChar = s.toCharArray();
//        strChar[0] = Character.toUpperCase(strChar[0]);
//        for (int i = 1; i < strChar.length; i++)
//            if (Character.isWhitespace(strChar[i - 1]))
//                strChar[i] = Character.toUpperCase(strChar[i]);
//        s = String.copyValueOf(strChar);
//        System.out.println(s);
    }
}
