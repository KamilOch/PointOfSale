package demo;

import domain.BarCodesScanner;

public class DemoScanner implements BarCodesScanner {

    @Override
    public String scanProductBarCode() {
        return "234561";
    }

}
