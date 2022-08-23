package com.epam.rd.autotasks;

import java.util.ArrayList;

public class TaskCarousel {

    protected ArrayList<Task> carousel = new ArrayList<Task>();
    protected int carouselExcIndex = 0;
    protected Task listElement;
    protected int maxCapacity;
    protected int realCapacity = 0;
    public TaskCarousel(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean addTask(Task task) {
        if(task == null || task.isFinished() || isFull()) return false;
        if(realCapacity == maxCapacity) return false;

        carousel.add(task);
        realCapacity++;

        return true;
    }

    public boolean execute() {
        if (isEmpty()) return false;

        //System.out.println(" carouselExcIndex = " + carouselExcIndex);

        return executeProcess();
    }

    private boolean executeProcess()
    {

            if(carouselExcIndex == carousel.size()) carouselExcIndex = 0;

                if (carousel.get(carouselExcIndex) instanceof CountDownTask
                        && ((CountDownTask) carousel.get(carouselExcIndex)).getValue() == 0) {
                    return false;
                }

            carousel.get(carouselExcIndex).execute();

                if (carousel.get(carouselExcIndex).isFinished()) {
                    carousel.remove(carouselExcIndex);
                    realCapacity--;

                   // System.out.println(" Ex Leng = " + realCapacity);
                    return true;
                } else carouselExcIndex++;

             //System.out.println(" passesNumber = " + carouselExcIndex);


        return true;
    }

    public boolean isFull() {
        if(realCapacity == maxCapacity) return true;
        else return false;
    }

    public boolean isEmpty() {
        if(realCapacity == 0) return true;
        else return false;
    }


    public void print() {
        System.out.print("Car = ");
        for(Task e : carousel) {
            if(e == null) continue;
            System.out.print(e.toString() + " / ");
        }
        System.out.print(" Leng = " + realCapacity);
        System.out.println();
    }
}
