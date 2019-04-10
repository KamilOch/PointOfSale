package demo;

import domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class POSTest {


    public static void main(String[] args) throws InterruptedException {
        Printer printer = new DemoPrinter();
        LcdDisplay display = new DemoMonitor();
        BarCodesScanner scanner = new DemoScanner();
        List<Product> products = new ArrayList<>();

        products.add(new Product("123456", "Carrot", new BigDecimal("2.10")));
        products.add(new Product("234561", "Onion", new BigDecimal("1.15")));
        products.add(new Product("345612", "Potato", new BigDecimal("3.02")));

        PointOfSale pos = new PointOfSale(printer, display, scanner, products);

        pos.scanProduct();
        Thread.sleep(1000);
        pos.scanProduct();
        Thread.sleep(1000);
        pos.exit();

        Thread.sleep(1000);
        pos.scanProduct();
        Thread.sleep(1000);
        pos.scanProduct();
        Thread.sleep(1000);
        pos.scanProduct();
        Thread.sleep(1000);
        pos.exit();
    }
}
