package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("First", 3, 0);
        Horse horse2 = new Horse("Second", 3, 0);
        Horse horse3 = new Horse("Third", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();

        game.printWinner();
    }



    public List<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for(Horse horse : horses) {
            horse.move();
        }
    }
    public void print() {
        for (Horse horse: horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        Horse h = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > h.getDistance()) {
                h = horse;
            }
        }
        return h;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }




}
