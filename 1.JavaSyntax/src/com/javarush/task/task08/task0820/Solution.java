package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        for(int i = 0; i < 4; i++) {
            result.add(new Cat());
        }
        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> result = new HashSet<Dog>();
        for(int i = 0; i < 3; i++) {
            result.add(new Dog());
        }
        //напишите тут ваш код
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        HashSet result = new HashSet();
        for(Cat cat : cats) {
            result.add(cat);
        }
        for(Dog dog : dogs) {
            result.add(dog);
        }
        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        pets.removeAll(cats);
//        Iterator iterator = pets.iterator();
//        for(Cat cat : cats) {
//            while (iterator.hasNext()) {
//                if(cat.equals(iterator.next())) iterator.remove();
//            }
//        }

//        while (iterator.hasNext()) {
//            for(Cat cat : cats) {
//                if (cat.equals(iterator.next())) iterator.remove();
//            }
//        }
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for(Object ob : pets) {
            System.out.println(ob);
        }
    }

    //напишите тут ваш код
    public static class Cat {
    }

    public static class Dog {
    }
}
