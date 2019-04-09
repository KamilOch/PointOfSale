package Domain;

import Demo.Product;


import java.util.ArrayList;
import java.util.List;

public class PointOfSale {

    private Printer printer;
    private LcdDisplay display;
    private BarCodesScanner scanner;
    private List<Product> productsList;

    private Product scannedProduct;
    private List <Product> shoppingList = new ArrayList<>();
    private double purchaseCost=0;
    private String message ="null";
    private String bill="";

    public PointOfSale(Printer printer, LcdDisplay display, BarCodesScanner scanner, List<Product> productsList) {
        this.printer = printer;
        this.display = display;
        this.scanner = scanner;
        this.productsList = productsList;
    }

    public void buyProduct (String scannedBarCode){
        if(checkBarCode(scannedBarCode)){
            if(findProduct(scannedBarCode)){
                addToShopingCart(scannedProduct);
            } else  display.displayMessage(message);
        } else display.displayMessage(message);
    }


    public void addToShopingCart (Product scannedProduct ){
        shoppingList.add(scannedProduct);
        bill+="Article "+scannedProduct.getProductName()+" price: "+scannedProduct.getProductPrice()+"\n";
        purchaseCost +=scannedProduct.getProductPrice();
        message="Article "+ scannedProduct.getProductName()+" price: "+scannedProduct.getProductPrice();
        display.displayMessage(message);
    }

    public boolean findProduct (String scanedBarCode){
        for (int i=0; i<productsList.size(); i++) {
            if (productsList.get(i).getProductBarCode().equals(scanedBarCode)){
                scannedProduct = productsList.get(i);
                return true;
            } else message = "Demo.Product not found";
        }
        return false;
    }

     public boolean checkBarCode (String scannedBarCode){
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
        shoppingList.clear();
        printer.printReceipt(bill+"\nTotal price: "+purchaseCost);
    }
}
