import java.util.ArrayList;
import java.util.List;

public class POSTest {


    public static void main(String[] args) throws InterruptedException {
        Printer printer = null;
        LcdDisplay display = new Monitor();
        BarCodesScanner scanner = new Skaner();
        List<Product> products = new ArrayList<>();

        PointOfSale pos = new PointOfSale(printer, display, scanner, products);

        pos.scanProduct();
        scanner.ustawZwracanyKod()
        Thread.sleep(1000);
        pos.scanProduct();
        Thread.sleep(1000);
        pos.exit();
    }
}
