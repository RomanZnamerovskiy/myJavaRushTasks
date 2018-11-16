package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));

        File file = new File("R:\\file1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

        Solution savedObject = new Solution(5);
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.flush();

        Solution loadedObject = new Solution(10);
        loadedObject = (Solution)objectInputStream.readObject();
        System.out.println(loadedObject.string.equals(savedObject.string));



    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
