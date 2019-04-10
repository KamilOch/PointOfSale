import demo.DemoMonitor;
import demo.DemoPrinter;
import demo.DemoScanner;
import domain.Product;
import domain.BarCodesScanner;
import domain.LcdDisplay;
import domain.PointOfSale;
import domain.Printer;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;


public class PointOfSaleTest {

        private Printer printerMock = mock(DemoPrinter.class);
        private LcdDisplay displayMock = mock(DemoMonitor.class);
        private BarCodesScanner scannerMock = mock(DemoScanner.class);
        private List<Product> productsMock =new ArrayList<>();

        private PointOfSale posTest = new PointOfSale(printerMock, displayMock, scannerMock, productsMock);

    //Printer tests
    @Test
    public void shouldPrintEmptyReceipt(){
        // Given

        // When
        posTest.exit();
        // Then
        verify(printerMock).printReceipt("\nTotal price: 0");
    }
    @Test
    public void shouldPrintReceiptForOneProduct(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("Test123456");
        productsMock.add(new Product("Test123456", "TestCarrot", new BigDecimal("99.99")));
        posTest.scanProduct();
        // When
        posTest.exit();
        // Then
        verify(printerMock).printReceipt("Article TestCarrot price: 99.99\n" +
                "\n" +
                "Total price: 99.99");
    }
    @Test
    public void shouldPrintReceiptForTwoProducts(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("Test123456");
        productsMock.add(new Product("Test123456", "TestCarrot", new BigDecimal("99.99")));
        posTest.scanProduct();
        posTest.scanProduct();
        // When
        posTest.exit();
        // Then
        verify(printerMock).printReceipt("Article TestCarrot price: 99.99\n" +
                "Article TestCarrot price: 99.99\n" +
                "\n" +
                "Total price: 199.98");
    }
    @Test
    public void shouldPrintReceiptWhenProductIsMissing(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("No product");
        posTest.scanProduct();
        // When
        posTest.exit();
        // Then
        verify(printerMock).printReceipt("\nTotal price: 0");
    }
    @Test
    public void shouldPrintReceiptWhenMissingScannedBarCode(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("");
        posTest.scanProduct();
        // When
        posTest.exit();
        // Then
        verify(printerMock).printReceipt("\nTotal price: 0");
    }
    //Display tests
    @Test
    public void shouldDisplayProductNameAndPriceWhenScannedBarCode(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("Test123456");
        productsMock.add(new Product("Test123456", "TestCarrot", new BigDecimal("99.99")));
        // When
        posTest.scanProduct();
        // Then
        verify(displayMock).displayMessage("Article TestCarrot price: 99.99");
    }
    @Test
    public void shouldDisplayErrorMessageWhenProductNotFound(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("xxxx");
        // When
        posTest.scanProduct();
        // Then
        verify(displayMock).displayMessage("Product not found");
    }
    @Test
    public void shouldDisplayErrorMessageWhenMissingScannedBarCode(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("");
        // When
        posTest.scanProduct();
        // Then
        verify(displayMock).displayMessage("Invalid bar-code");
    }

    @Test
    public void shouldDisplayEmptyReceipt(){
        // Given

        // When
        posTest.exit();
        // Then
        verify(displayMock).displayMessage("Total price: 0");
    }
    @Test
    public void shouldDisplayReceiptForOneProduct(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("Test123456");
        productsMock.add(new Product("Test123456", "TestCarrot", new BigDecimal("99.99")));
        posTest.scanProduct();
        // When
        posTest.exit();
        // Then
        verify(displayMock).displayMessage("Total price: 99.99");
    }
    @Test
    public void shouldDisplayReceiptForTwoProducts(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("Test123456");
        productsMock.add(new Product("Test123456", "TestCarrot", new BigDecimal("99.99")));
        posTest.scanProduct();
        posTest.scanProduct();
        // When
        posTest.exit();
        // Then
        verify(displayMock).displayMessage("Total price: 199.98");
    }
    @Test
    public void shouldClearShoppingListWhenExit(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("Test123456");
        productsMock.add(new Product("Test123456", "TestCarrot", new BigDecimal("99.99")));
        // When
        posTest.scanProduct();
        posTest.exit();
        posTest.scanProduct();
        posTest.scanProduct();
        posTest.exit();

        // Then
        verify(printerMock).printReceipt("Article TestCarrot price: 99.99\n" +
                "Article TestCarrot price: 99.99\n" +
                "\n" +
                "Total price: 199.98");
    }
}
