package com.theforest.practice;

public class TaskExample2 {


    public static void main(String[] args) throws InterruptedException {
        Thread left = new Thread(new Foot("left"));
        Thread right = new Thread(new Foot("right"));

        left.start();
        right.start();
    }
}

class Foot implements Runnable {
    private final String name;

    private final String lock = "lock";

    private volatile static int currentLeg = 0; // 0-left, 1-right


    public Foot(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                step();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void step() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (currentLeg == 0 && this.name.equals("left") ||
                        currentLeg == 1 && this.name.equals("right")) {
                    System.out.println("Step by " + name);
                    currentLeg = (currentLeg + 1) % 2;
                    lock.notify();
                    return;
                } else {
                    lock.wait();
                }
            }
        }
    }
}