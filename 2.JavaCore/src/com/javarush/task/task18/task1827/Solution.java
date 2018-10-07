package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.lang.reflect.Array;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        if (args.length > 0 && args[0].equals("-c")) {
            reader = new BufferedReader(new FileReader((fileName)));
            Integer maxIndex = 0;
            while (reader.ready()) {
                String data = reader.readLine();
                if (!data.isEmpty()) {
                    int index = Integer.parseInt(data.substring(0, 8).trim());
                    if (maxIndex == 0 || maxIndex < index)
                        maxIndex = index;
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.newLine();
            String sPrice = String.format("%-8.2f", Double.parseDouble(args[2])).replace(',', '.');
            writer.write(String.format("%-8d%-30.30s%-8s%-4d", maxIndex + 1, args[1], sPrice, Integer.parseInt(args[3])));
            writer.close();
        }
    }
}
