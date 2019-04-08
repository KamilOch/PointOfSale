public class Printer implements PrinterInt {

    @Override
    public void printMessage(String message) {
        System.out.println("Printer: "+message);
    }

    @Override
    public void printReceipt(String receipt) {
        System.out.println("Printer receipt:\n"+ receipt);
    }
}
