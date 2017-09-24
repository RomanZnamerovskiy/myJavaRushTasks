package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        if (firstNumber <= 0) throw new NumberFormatException();
        int secondNumber = sc.nextInt();
        if (secondNumber <= 0) throw new NumberFormatException();

        int min = firstNumber < secondNumber ? firstNumber : secondNumber;

        for (int i = min; i > 0; i--) {
            if( (firstNumber % i == 0) && (secondNumber % i == 0) ) {
                System.out.println(i);
                break;
            }
        }
    }
}
