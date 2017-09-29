package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadInfinitely("infinit"));
        threads.add(new ThreadInterrupted("interrupted"));
        threads.add(new ThreadUra("Ura"));
        threads.add(new ThreadMessage("Message"));
        threads.add(new ThreadReadNumbers("ReadNumbers"));
    }


    public static void main(String[] args) {
        for(Thread thread : threads) {
            thread.start();
        }
    }

    public static class ThreadInfinitely extends Thread {
        public ThreadInfinitely(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class ThreadInterrupted extends Thread {
        public ThreadInterrupted(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadUra extends Thread {
        public ThreadUra(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadMessage extends Thread implements Message {
        private boolean die;
        public ThreadMessage(String name) {
            super(name);
            die = false;
        }

        @Override
        public void run() {
            while(die == false) {
            }
        }

        @Override
        public void showWarning() {
            die = true;
        }
    }

    public static class ThreadReadNumbers extends Thread {
        public ThreadReadNumbers(String name) {
            super(name);
        }

        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            String s = null;
            while(true) {
                try {
                    s = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s.equals("N")) break;

                sum += Integer.parseInt(s);
            }
            System.out.println(sum);


        }
    }
}