package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        //read name of the file
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        //verify is the program has the console arguments
        if (args.length > 0) {

            //put all file to Map<Integer, String>. Integer is the qual to id
            reader = new BufferedReader(new FileReader(fileName));
            HashMap<Integer, String> map = new LinkedHashMap<>();
            while (reader.ready()) {
                String data = reader.readLine();
                int i = Integer.parseInt(data.substring(0, 8).trim());
                map.put(i, data);
            }
            reader.close();

            if (args[0].equals("-u")) { //verify is the first console argument equals to "-u"
                String lineValue = map.get(args[1]);
                String id, productName,price, quantity;
//                if (args.length == 5) {
                    id = args[1];
                    productName = args[2];
                    price = args[3];
                    quantity = args [4];
                    String updatedLine = String.format("%-8s%-30.30s%-8s%-4s", id, productName, price, quantity);
                    map.put(Integer.parseInt(id.trim()), updatedLine);
//                } else if (args.length > 5) {
//
//                }


            } else if (args[0].equals("-d")) { //verify is the first console argument equals to "-d"
                map.remove(Integer.parseInt(args[1]));
            }

            //write the file from the Map
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (String s: map.values()) {
                writer.write(s);
                writer.newLine();
            }
            writer.close();

        }
    }
}
