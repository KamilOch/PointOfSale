package Demo;

import Domain.Printer;

public class DemoPrinter implements Printer {

    @Override
    public void printReceipt(String receipt) {
        System.out.println("Demo.DemoPrinter receipt:\n"+ receipt);
    }
}
