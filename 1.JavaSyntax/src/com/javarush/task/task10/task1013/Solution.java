package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private int age, salary;
        private String name, surname, color;
        private boolean sex;
        public Human(int age){
            this.age = age;
        }
        public Human(int age, int salary) {
            this.age = age;
            this.salary = salary;
        }

        public Human(int age, int salary, String name) {
            this.age = age;
            this.salary = salary;
            this.name = name;
        }

        public Human(int age, int salary, String name, String surname) {
            this.age = age;
            this.salary = salary;
            this.name = name;
            this.surname = surname;
        }

        public Human(int age, int salary, String name, String surname, String color) {
            this.age = age;
            this.salary = salary;
            this.name = name;
            this.surname = surname;
            this.color = color;
        }

        public Human(int age, int salary, String name, String surname, String color, boolean sex) {
            this.age = age;
            this.salary = salary;
            this.name = name;
            this.surname = surname;
            this.color = color;
            this.sex = sex;
        }

        public Human(int salary, String name, String surname, String color, boolean sex) {
            this.salary = salary;
            this.name = name;
            this.surname = surname;
            this.color = color;
            this.sex = sex;
        }

        public Human(String name, String surname, String color, boolean sex) {
            this.name = name;
            this.surname = surname;
            this.color = color;
            this.sex = sex;
        }

        public Human(String surname, String color, boolean sex) {
            this.surname = surname;
            this.color = color;
            this.sex = sex;
        }

        public Human(String color, boolean sex) {
            this.color = color;
            this.sex = sex;
        }

    }
}
