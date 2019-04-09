package Demo;

import Domain.BarCodesScanner;

public class DemoScanner implements BarCodesScanner {

    @Override
    public String scanProductBarCode() {
        return "345612";
    }

}
