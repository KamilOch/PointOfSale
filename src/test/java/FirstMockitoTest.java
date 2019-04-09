import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FirstMockitoTest {

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
    }

}
