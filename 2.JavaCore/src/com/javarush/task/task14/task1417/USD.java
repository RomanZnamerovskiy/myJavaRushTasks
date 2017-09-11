package com.javarush.task.task14.task1417;

/**
 * Created by User on 04.09.2017.
 */
public class USD  extends Money {
    @Override
    public String getCurrencyName() {
        return "USD";
    }

    public USD(double amount) {
        super(amount);
    }
}
