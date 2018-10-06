package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat dateFormatPrint = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        //create person
        if (args[0].startsWith("-c")) {
            Date date = null;
            try {
                date = dateFormat.parse(args[3]);
            } catch (ParseException e) {
                e.getMessage();
            }

        //VALIDATOR: При запуске программы с параметром -с программа должна добавлять человека с заданными
        // параметрами в конец списка allPeople, и выводить id (index) на экран.
            if (args[2].startsWith("м")) {
            Person person = Person.createMale(args[1], date);
            allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            } else {
                Person person = Person.createFemale(args[1], date);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
        }

        //update person
        if (args[0].startsWith("-u")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            try {
                person.setBirthDay(dateFormat.parse(args[4]));
            } catch (ParseException e) {
                e.getMessage();
            }
            if (args[3].equals("м")) {
                person.setSex(Sex.MALE);
            } else {
                person.setSex(Sex.FEMALE);
            }
        }

        //delete
        if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));

            person.setSex(null);
            person.setBirthDay(null);
            person.setName(null);

        }


        //show information about person
        if (args[0].startsWith("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            String sex;
            if (person.getSex()==Sex.MALE) sex = "м";
            else sex = "ж";
            System.out.println(person.getName() + " " + sex + " " + dateFormatPrint.format(person.getBirthDay()));
        }
    }
}
