package Demo;

import Domain.Printer;

public class DemoPrinter implements Printer {

    @Override
    public void printReceipt(String receipt) {
        System.out.println("DemoPrinter receipt:\n"+ receipt);
    }
}
