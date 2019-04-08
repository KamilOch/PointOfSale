import java.util.ArrayList;
import java.util.List;

public class POSTest {


    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        LcdDisplayInt display = new Monitor();
        BarCodesScannerInt scanner = new Skaner();
        List<Product> products = new ArrayList<>();

        products.add(new Product("123456", "Carrot", 2.10));
        products.add(new Product("234561", "Onion", 1.15));
        products.add(new Product("345612", "Potato", 3.02));

        PointOfSale pos = new PointOfSale(printer, display, scanner, products);

        pos.scanProduct();
        scanner.ustawZwracanyKod();
        Thread.sleep(1000);
        pos.scanProduct();
        Thread.sleep(1000);
        pos.exit();
    }
}
