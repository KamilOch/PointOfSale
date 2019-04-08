public class Printer implements PrinterInt {

    @Override
    public void printMessage(String message) {
        System.out.println("Drukarka "+message);
    }

    @Override
    public void printReceipt(String receipt) {
        System.out.println("Drukarka rachunek "+ receipt);

    }
}
