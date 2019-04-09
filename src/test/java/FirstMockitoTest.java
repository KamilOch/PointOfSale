import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FirstMockitoTest {

    Printer printer = new Printer();
    LcdDisplayInt display = new Monitor();
    BarCodesScannerInt scanner = new Scanner();
    List<Product> products = new ArrayList<>();

    PointOfSale posMock = new PointOfSale(printer, display, scanner, products);

    @Test
    public void test(){
        assertTrue(true);
    }

    @Test
    public void letsMockCheckBarCodeTrue(){

        PointOfSale posMock = mock(PointOfSale.class);
        when(posMock.checkBarCode("1111"));
        assertTrue(true);
    }
    @Test
    public void letsMockCheckBarCodeFalse(){

        PointOfSale posMock = mock(PointOfSale.class);
        when(posMock.checkBarCode("")).thenReturn(false);
        assertFalse("Invalid bar-code",false);
        assertFalse(false);
    }

}
