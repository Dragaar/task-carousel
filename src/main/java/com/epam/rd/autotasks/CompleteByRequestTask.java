package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {

    private boolean complete = false;
    private boolean isFibished = false;

    CompleteByRequestTask(){}
    @Override
    public void execute() {
        if(complete) isFibished = true;
    }

    @Override
    public boolean isFinished() {
        return isFibished;
    }

    public void complete() {
        complete = true;
    }

    @Override
    public String toString() {
        return "CompleteByRequestTask{" +
                "complete=" + complete +
                ", isFibished=" + isFibished +
                '}';
    }
}
