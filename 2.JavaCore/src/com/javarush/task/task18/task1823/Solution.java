package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s = reader.readLine();
            if (s.equals("exit")) break;
            ReadThread th = new ReadThread(s);
            th.start();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                byte[] b = new byte[fileInputStream.available()];
                fileInputStream.read(b);
                fileInputStream.close();
                Map<Byte, Integer> map = new TreeMap<>();
                for (byte bytesFromArray : b) {
                    if (map.containsKey(bytesFromArray)) {
                        map.put(bytesFromArray, map.get(bytesFromArray) + 1);
                    } else {
                        map.put(bytesFromArray, 1);
                    }
                }

                int max = 0;
                int maxValue = 0;
                for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
                    if(max < entry.getValue()) {
                        max = entry.getValue();
                        maxValue = entry.getKey();
                    }
                }
                synchronized (resultMap) {
                resultMap.put(fileName, maxValue);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
