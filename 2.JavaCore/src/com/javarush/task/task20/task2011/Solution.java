package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
            out.flush();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year = in.readInt();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Apartment apartment = new Apartment("Ukraine", 2000);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutput = new ObjectOutputStream(byteArrayOutputStream);
        ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream("R:\\file1.txt"));
        apartment.writeExternal(objectOutput);


//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("R:\\file1.txt"));
        Apartment apartment2 = new Apartment();
        apartment2.readExternal(objectInputStream);
        System.out.println(apartment2);

    }
}
