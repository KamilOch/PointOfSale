import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;


public class FirstMockitoTest {


        Printer printerMock = mock(DemoPrinter.class);
        LcdDisplay displayMock = mock(DemoMonitor.class);
        BarCodesScanner scannerMock = mock(DemoScanner.class);
       // Product productMock = mock(Product.class);
        List<Product> productsMock =new ArrayList<>();

/*
    productsMock.add(new Product("123456", "Carrot", 2.10));
    productsMock.add(new Product("999999","testName",10.10));
    productsMock.add(new Product("234561", "Onion", 1.15));
    productsMock.add(new Product("345612", "Potato", 3.02));
*/
        PointOfSale posTest = new PointOfSale(printerMock, displayMock, scannerMock, productsMock);

    @Test
    public void shouldPrintEmptyRecipt(){
        // Given

        // When
        posTest.exit();
        // Then
        verify(printerMock).printReceipt("\nTotal price: 0.0");
    }
    @Test
    public void shouldPrintReceiptForOneProduct(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("Test123456");
        productsMock.add(new Product("Test123456", "TestCarrot", 99.99));
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
        productsMock.add(new Product("Test123456", "TestCarrot", 99.99));
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
        verify(printerMock).printReceipt("\nTotal price: 0.0");
    }
    @Test
    public void shouldPrintReceiptWhenMissingScannedBarCode(){
        // Given
        when(scannerMock.scanProductBarCode()).thenReturn("");
        posTest.scanProduct();
        // When
        posTest.exit();
        // Then
        verify(printerMock).printReceipt("\nTotal price: 0.0");
    }

}
