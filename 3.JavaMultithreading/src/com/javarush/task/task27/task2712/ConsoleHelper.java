package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
            return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> selectedDishes = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Select the dish");
        while (true) {
            String s = readString();
            if (s.equals("exit")) {
                return selectedDishes;
            }
            for (Dish dish : Dish.values()) {
                if (dish.toString().equals(s)) {
                    selectedDishes.add(dish);
                    break;
                } else {
                    writeMessage("We do not have such dish, select correct name of dish");
                }
            }
        }

    }

}
