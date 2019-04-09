package Demo;

import Domain.LcdDisplay;

public class DemoMonitor implements LcdDisplay {

    @Override
    public void displayMessage(String message) {
        System.out.println("Demo.DemoMonitor "+message);
    }
}
