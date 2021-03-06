package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PointOfSale {

    private Printer printer;
    private LcdDisplay display;
    private BarCodesScanner scanner;
    private List<Product> productsList;

    private Product scannedProduct;
    private List <Product> shoppingList = new ArrayList<>();
    private BigDecimal purchaseCost= new BigDecimal(0);
    private String message ="null";
    private String bill="";

    public PointOfSale(Printer printer, LcdDisplay display, BarCodesScanner scanner, List<Product> productsList) {
        this.printer = printer;
        this.display = display;
        this.scanner = scanner;
        this.productsList = productsList;
    }
    private void buyProduct (String scannedBarCode){
        if(checkBarCode(scannedBarCode)){
            if(findProduct(scannedBarCode)){
                addToShopingCart(scannedProduct);
            }
        } else display.displayMessage(message);
    }
    private void addToShopingCart (Product scannedProduct ){
        shoppingList.add(scannedProduct);
        bill+="Article "+scannedProduct.getProductName()+" price: "+scannedProduct.getProductPrice()+"\n";
        purchaseCost = purchaseCost.add(scannedProduct.getProductPrice());
        message="Article "+ scannedProduct.getProductName()+" price: "+scannedProduct.getProductPrice();
        display.displayMessage(message);
    }

    private boolean findProduct (String scanedBarCode){
        for (int i=0; i<productsList.size(); i++) {
            if (productsList.get(i).getProductBarCode().equals(scanedBarCode)){
                scannedProduct = productsList.get(i);
                return true;
            }
        } message = "Product not found";
        display.displayMessage(message);
        return false;
    }
     private boolean checkBarCode (String scannedBarCode){
        if (scannedBarCode.isEmpty()){
            message = "Invalid bar-code";
            return false;
        } else return true;
    }
    public void scanProduct() {
        String scannedCode =scanner.scanProductBarCode();
        buyProduct (scannedCode);
    }
    public void exit() {
        printer.printReceipt(bill+"\nTotal price: "+purchaseCost);
        display.displayMessage("Total price: "+purchaseCost);
        scannedProduct = null;
        shoppingList.clear();
        purchaseCost= new BigDecimal(0);
        message ="null";
        bill="";
    }
}
