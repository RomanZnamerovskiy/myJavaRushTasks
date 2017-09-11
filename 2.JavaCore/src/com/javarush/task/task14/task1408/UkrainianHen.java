package com.javarush.task.task14.task1408;

/**
 * Created by User on 04.09.2017.
 */
class UkrainianHen extends Hen {
    int getCountOfEggsPerMonth() { return 20; }
    String getDescription() { return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " +
            getCountOfEggsPerMonth() + " яиц в месяц."; }
}
