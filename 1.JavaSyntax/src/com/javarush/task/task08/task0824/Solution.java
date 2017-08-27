package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> sun1Childrens = new ArrayList<>();
        Human sun1 = new Human("sun1", true, 15, sun1Childrens);
        System.out.println(sun1);
        ArrayList<Human> sun2Childrens = new ArrayList<>();
        Human sun2 = new Human("sun2", true, 17, sun2Childrens);
        System.out.println(sun2);
        ArrayList<Human> sun3Childrens = new ArrayList<>();
        Human sun3 = new Human("sun3", true, 21, sun3Childrens);
        System.out.println(sun3);

        ArrayList<Human> fatherChildren = new ArrayList<>();
        fatherChildren.add(sun1);
        fatherChildren.add(sun2);
        fatherChildren.add(sun3);
        Human father = new Human("father", true, 35, fatherChildren);
        System.out.println(father);

        ArrayList<Human> motherChildren = fatherChildren;
        Human mother = new Human("mother", false, 32, motherChildren);
        System.out.println(mother);

        ArrayList<Human> grandfatrhesChildren1 = new ArrayList<>();
        grandfatrhesChildren1.add(father);
        Human grandfather1 = new Human("granfather1", true, 62, grandfatrhesChildren1);
        System.out.println(grandfather1);
        Human grandmother1 = new Human ("grandmother1", false, 59, grandfatrhesChildren1);
        System.out.println(grandmother1);

        ArrayList<Human> grandfatrhesChildren2 = new ArrayList<>();
        grandfatrhesChildren2.add(mother);
        Human grandfather2 = new Human("granfather2", true, 61, grandfatrhesChildren2);
        System.out.println(grandfather2);
        Human grandmother2 = new Human ("grandmother2", false, 58, grandfatrhesChildren2);
        System.out.println(grandmother2);






    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;
        Human (String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
