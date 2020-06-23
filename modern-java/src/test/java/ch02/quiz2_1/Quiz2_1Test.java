package ch02.quiz2_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Quiz2_1Test {
    List<Apple> apples;
    ApplePrinter colorPrinter   = new AppleColorPrinter();
    ApplePrinter weightPrinter  = new AppleWeightPrinter();
    ApplePrinter isHeavyPrinter = new AppleIsHeavyPrinter();

    @Before
    public void init() {
        apples = new ArrayList<Apple>();
        apples.add(new Apple(Color.Red, 100));
        apples.add(new Apple(Color.Red, 300));
        apples.add(new Apple(Color.Green, 250));
    }

    @After
    public void unInit() {
        apples.clear();
    }

    @Test
    public void 사과_색상_출력() {
        System.out.println("Test, 사과 색상 출력");
        Quiz2_1.prettyPrintApple(apples, colorPrinter);
    }

    @Test
    public void 사과_무거운지_출력() {
        System.out.println("Test, 사과 무거운지 출력");
        Quiz2_1.prettyPrintApple(apples, isHeavyPrinter);
    }

    @Test
    public void 사과_무게_출력() {
        System.out.println("Test, 사과 무게 출력");
        Quiz2_1.prettyPrintApple(apples, weightPrinter);
    }
}
