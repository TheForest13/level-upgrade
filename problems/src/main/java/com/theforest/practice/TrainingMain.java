package com.theforest.practice;

import java.util.concurrent.TimeUnit;

public class TrainingMain {
    private static boolean stopFlag; //todo volatile подробнее почитать

    public static void main(String[] args) throws InterruptedException {

/*
        Parent example = new Child(); // print() -> 0
        example.print(); // print -> 4
*/

        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopFlag) {
                    i++;
                    System.out.println(i);
                }
                System.out.println("DONE!");
            }
        });

        backgroundThread.start();
        backgroundThread.join(); //todo подробнее почитать
        TimeUnit.SECONDS.sleep(1);
        stopFlag = true;
    }
}

class Parent {
    public Parent() {
        print();
    }

    void print() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    int num = Math.round(3.5f);

    @Override
    void print() {
        System.out.println(num);
    }
}
