public class Monitor implements LcdDisplayInt {
    @Override
    public void displayMessage(String message) {
        System.out.println("Monitor "+message);
    }
}
