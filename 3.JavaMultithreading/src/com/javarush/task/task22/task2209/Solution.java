package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            stringBuilder.append(fileReader.readLine()).append(" ");
        }
        String[] strs = stringBuilder.toString().split("\\s+");
        StringBuilder result = getLine(strs);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
//        if (words == null || words.length == 0) {
//            return new StringBuilder();
//        }
//        String[] arrForChanges = Arrays.copyOf(words,words.length);
//        StringBuilder result = new StringBuilder(arrForChanges[0]);
//        for (int i = 1; i < arrForChanges.length; i++) {
//            if (arrForChanges[i] == null) continue;
//            char last = result.charAt(result.length() - 1);
//            for (int j = i; j < arrForChanges.length; j++) {
//                if (arrForChanges[j] == null) continue;
//                if (Character.toUpperCase(last) == Character.toUpperCase(arrForChanges[j].charAt(0))) {
//                    result.append(" ").append(arrForChanges[j]);
//                    arrForChanges[j] = null;
//                }
//            }
//        }
//          return result;

        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) return result;
        if (words.length==1 || words[0].equals("")) return result.append(words[0]);

        ArrayList<String> wordsList = new ArrayList<>();

        wordsList.addAll(Arrays.asList(words));
        while (wordsList.remove("")){
            wordsList.remove("");
        }
        while (isYes(wordsList)) {
            Collections.shuffle(wordsList);
        }
        for (String word: wordsList){
            result.append(word).append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result;
    }

    public static boolean isYes(ArrayList<String> wordsList) {
        for (int i = 0; i < wordsList.size() - 1; i++) {
            String firstWord = wordsList.get(i).toLowerCase();
            String secondWord = wordsList.get(i + 1).toLowerCase();
            if (firstWord.charAt(firstWord.length() - 1) != secondWord.charAt(0)) return true;
        }
        return false;
    }
}
