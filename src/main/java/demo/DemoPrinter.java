package demo;

import domain.Printer;

public class DemoPrinter implements Printer {

    @Override
    public void printReceipt(String receipt) {
        System.out.println("Demo Printer receipt:\n"+ receipt);
    }
}
