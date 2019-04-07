import java.util.ArrayList;
import java.util.List;

public class PointOfSale {

    private Printer printer;
    private LcdDisplay display;
    private BarCodesScanner scanner;
    private List<Product> productsList;


    public PointOfSale(Printer printer, LcdDisplay display, BarCodesScanner scanner, List<Product> productsList) {
        this.printer = printer;
        this.display = display;
        this.scanner = scanner;
        this.productsList = productsList;
    }

    private Product scanedProduct;

    private List <Product> shoppingList = new ArrayList<>();
    private float purchaseCost;
    private String message;



    private void buyProduct (String scanedBarCode){

        if(checkBarCode(scanedBarCode)){
            if(findProduct(scanedBarCode)){
                addToShopingCart(scanedProduct);
            } else  display.displayMessage(message);

        } else display.displayMessage(message);
    }



    public void addToShopingCart (Product scanedProduct ){
        shoppingList.add(scanedProduct);
        purchaseCost +=scanedProduct.getProductPrice();
    }

    public boolean findProduct (String scanedBarCode){

        for (int i=0; i<productsList.size(); i++) {

            if ( productsList.get(i).getProductBarCode().equals(scanedBarCode)){
                scanedProduct = productsList.get(i);
                return true;
            } else message = "Product not found";
                return false;
        }

        return false;
    }

    public boolean checkBarCode (String scanedBarCode){
        if (scanedBarCode.equals("")){
            message = "Invalid bar-code";
            return false;
        } else return true;
    }


    public void scanProduct() {

        String kod =scanner.scanProductBarCode();
        buyProduct (kod);
    }

    public void exit() {

    }
}
