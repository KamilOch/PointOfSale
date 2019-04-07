import sun.awt.SunHints;

public class Monitor implements LcdDisplay {
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
