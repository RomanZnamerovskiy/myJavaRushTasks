package com.javarush.task.task20.task2025;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
//        Set<Long> set = new TreeSet<>();
//        for (long i = 1; i < N; i++) {
//            String stringNumber = String.valueOf(i);
//            int length = stringNumber.length();
//            long result = 0;
//            for (int i2 = length - 1; i2 >= 0; i2--) {
//                result += Math.pow(Character.getNumericValue(stringNumber.charAt(i2)), length);
////                for (int i3 = length; i3 > 0; i3--) {
////                    result *= Integer.valueOf(stringNumber.charAt(i2));
////                }
//            }
//            if (i == result)
//                set.add(i);
//        }
//        long[] result = new long[set.size()];
//        int iter = 0;
//        for (long lon: set) {
//            result[iter] = lon;
//            iter++;
//        }
//        return result;
        long[] result = null;
        LinkedList<Long> list = new LinkedList<>();

        // Создаем и инициализируем массив степененй
        long[][] mult = new long[10][19];
        for (int i = 0; i < mult.length; i++) {
            for (int j = 0; j < mult[i].length; j++) {
                long tmp = i;
                int degree = j;
                while (degree-- > 0) {
                    tmp*= i;
                }
                mult[i][j] = tmp;
            }
        }

        byte bitness_start = 1;
        long length = 10;

        for (long i = 1; i <=N; i++) {
            long tmp = i;
            long res = 0;

            do {
                res += mult[(int)tmp%10][bitness_start-1];
                tmp /= 10;
            } while (tmp != 0);

            if (res == i) {
                list.add(i);
            }

            if (i == length) {
                length *= 10;
                bitness_start++;
            }
        }


        result = new long[list.size()];
        int i = 0;
        for (Long value: list) {
            result[i++] = value;
        }

        return result;
    }

    public static void main(String[] args) {
//        long[] arr = Solution.getNumbers(Long.MAX_VALUE);
//        for (long l: arr) {
//            System.out.println(l);
//        }
    }
}
