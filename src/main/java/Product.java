
public class Product {

   private String productBarCode;
   private String productName;
   private float productPrice;

    public String getProductBarCode() {

        return productBarCode;
    }

    public String getProductName() {

        return productName;
    }

    public float getProductPrice() {
        float copyProductPrice = productPrice;
        return copyProductPrice;
    }
}