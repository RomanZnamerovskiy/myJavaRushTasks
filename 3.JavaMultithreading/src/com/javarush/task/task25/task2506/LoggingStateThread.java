package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        State currentState, lastState = null;
        do {
            currentState = thread.getState();
            if (currentState != lastState) {
                System.out.println(currentState);
                lastState = currentState;
            }
        } while (currentState != State.TERMINATED);
    }
}
