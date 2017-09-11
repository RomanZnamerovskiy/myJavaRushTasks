package com.javarush.task.task14.task1408;


/**
 * Created by User on 04.09.2017.
 */
class RussianHen extends Hen {
    int getCountOfEggsPerMonth() { return 15; }
    String getDescription() { return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " +
            getCountOfEggsPerMonth() + " яиц в месяц."; }
}
