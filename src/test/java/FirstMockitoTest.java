import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class FirstMockitoTest {


        PrinterInt printerMock = mock(Printer.class);
        LcdDisplayInt displayMock = mock(Monitor.class);
        BarCodesScannerInt scannerMock = mock(Scanner.class);
        Product productMock = mock(Product.class);
        List<Product> productsMock = new ArrayList<>();

/* nie pozwala mi stworzyc obiektow Product
    productsMock.add(new Product("123456", "Carrot", 2.10));
    productsMock.add(new Product("234561", "Onion", 1.15));
    productsMock.add(new Product("345612", "Potato", 3.02));
*/
        PointOfSale posTest = new PointOfSale(printerMock, displayMock, scannerMock, productsMock);


    @Test
    public void test(){
        assertTrue(true);
    }
    /* to mi kompletnie nie dziala!
        @Test
        public void letsMockCheckBarCodeTrue(){
            when(posTest.checkBarCode("1111")).thenReturn(true);
            assertTrue(true);
        }
        @Test
        public void letsMockCheckBarCodeFalse(){
            when(posTest.checkBarCode("")).thenReturn(false);
            assertFalse(false);
        }
        !!
        @Test
        public void CheckBarCodeTestTrue2(){
            when(posTest.checkBarCode("123456")).thenReturn(true);
            assertTrue(true);
        }
        @Test
        public void CheckBarCodeTestFalse2(){
            when(posTest.checkBarCode("")).thenReturn(false);
            assertFalse(false);
        }
         */
    @Test
    public void CheckBarCodeTestFalse(){
        String s ="";
        assertFalse(posTest.checkBarCode(s));
    }
    @Test
    public void CheckBarCodeTestTrue(){
        String s ="123456";
        assertTrue(posTest.checkBarCode(s));
    }

}
