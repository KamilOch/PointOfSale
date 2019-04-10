package domain;

import java.math.BigDecimal;

public class Product {

   private String productBarCode;
   private String productName;
   private BigDecimal productPrice;

    public Product(String productBarCode, String productName, BigDecimal productPrice) {
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

    public BigDecimal getProductPrice() {
        return productPrice;
    }
}