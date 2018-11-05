package com.javarush.task.task20.task2002;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Roma");
            user1.setLastName("RomaLastName");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            user1.setBirthDate(dateFormat.parse("2001-01-11"));
            user1.setCountry(User.Country.RUSSIA);
            user1.setMale(true);
            javaRush.users.add(user1);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Writer writer = new OutputStreamWriter(outputStream, "UTF8");
            SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy");

            for (User user: users) {
                writer.write(user.getFirstName()+ "," + user.getLastName()+ "," + sdf.format(user.getBirthDate()) + "," + user.getCountry() + "," +user.isMale() + "\r\n");
            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy");

            while (reader.ready()) {
                String s = reader.readLine();
                String[] strs = s.split(",");
                User user = new User();
                user.setFirstName(strs[0]);
                user.setLastName(strs[1]);
                user.setBirthDate(sdf.parse(strs[2]));
                user.setCountry(User.Country.valueOf(strs[3]));
                user.setMale(Boolean.valueOf(strs[4]));
                this.users.add(user);

                }

                reader.close();
            }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
