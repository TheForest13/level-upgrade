package com.theforest.practice.concurrency;

public class ConcurrencyServiceDemo {
    public static void main(String[] args) {
        ConcurrencyService service = new ConcurrencyService();

        service.readData();
        service.showGreetingMessage();
        service.calculateFactorial(50);
        service.calculateSum(100);
        service.finishProgram();
    }
}
