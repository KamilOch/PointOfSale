import java.util.ArrayList;
import java.util.List;

public class PointOfSale {

    private PrinterInt printer;
    private LcdDisplayInt display;
    private BarCodesScannerInt scanner;
    private List<Product> productsList;

    private Product scannedProduct;
    private List <Product> shoppingList = new ArrayList<>();
    private double purchaseCost=0;
    private String message ="null";
    private String bill="";

    public PointOfSale(PrinterInt printer, LcdDisplayInt display, BarCodesScannerInt scanner, List<Product> productsList) {
        this.printer = printer;
        this.display = display;
        this.scanner = scanner;
        this.productsList = productsList;
    }

    private void buyProduct (String scannedBarCode){

        if(checkBarCode(scannedBarCode)){
            if(findProduct(scannedBarCode)){
                addToShopingCart(scannedProduct);
            } else  display.displayMessage(message);

        } else display.displayMessage(message);
    }


    private void addToShopingCart (Product scannedProduct ){
        shoppingList.add(scannedProduct);
        bill+="Article "+scannedProduct.getProductName()+" price: "+scannedProduct.getProductPrice()+"\n";
        purchaseCost +=scannedProduct.getProductPrice();
        message="Article "+ scannedProduct.getProductName()+" price: "+scannedProduct.getProductPrice();
        display.displayMessage(message);
    }

    private boolean findProduct (String scanedBarCode){

        for (int i=0; i<productsList.size(); i++) {

            if (productsList.get(i).getProductBarCode().equals(scanedBarCode)){
                scannedProduct = productsList.get(i);
                return true;
            } else message = "Product not found";
        }
        return false;
    }

     private boolean checkBarCode (String scanedBarCode){

        if (scanedBarCode.isEmpty()){
            message = "Invalid bar-code";
            return false;
        } else return true;
    }


    public void scanProduct() {

        String scannedCode =scanner.scanProductBarCode();
        buyProduct (scannedCode);
    }

    public void exit() {

        shoppingList.clear();
        printer.printReceipt(bill+"\nTotal price: "+purchaseCost);
    }
}
