package com.epam.rd.autotasks;

public class CountDownTask implements Task{

    private int countDownValue;
    private boolean isFibished = false;
    public CountDownTask(int value) {

        if(value <= 0) {countDownValue = 0; isFibished = true;}
        else countDownValue = value;

    }

    public int getValue() {
        return countDownValue;
    }


    @Override
    public void execute() {
        if(countDownValue <= 0) {isFibished = true; return;}
        countDownValue--;
        if(countDownValue == 0) {isFibished = true;}
    }

    @Override
    public boolean isFinished() {
       return isFibished;
    }

    @Override
    public String toString() {
        return "CountDownTask{" +
                "countDownValue=" + countDownValue +
                ", isFibished=" + isFibished +
                '}';
    }
}
