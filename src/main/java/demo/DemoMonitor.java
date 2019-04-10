package demo;

import domain.LcdDisplay;

public class DemoMonitor implements LcdDisplay {

    @Override
    public void displayMessage(String message) {
        System.out.println("DemoMonitor "+message);
    }
}
