package demo;

public class Product {

   private String productBarCode;
   private String productName;
   private double productPrice;

    public Product(String productBarCode, String productName, double productPrice) {
        this.productBarCode = productBarCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }


    public String getProductBarCode() {
        return productBarCode;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        double copyProductPrice = productPrice;
        return copyProductPrice;
    }
}