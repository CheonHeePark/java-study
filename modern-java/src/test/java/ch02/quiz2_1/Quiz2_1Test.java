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

    @Test
    public void 람다사용_사과_색상_출력() {
        System.out.println("Test, 람다사용한 사과 무게 출력");
        Quiz2_1.prettyPrintApple(apples, (apple) -> String.valueOf(apple.getColor())
       );
    }

    @Test
    public void 람다사용_사과_무거운지_출력() {
        System.out.println("Test, 람다사용한 사과 무거운지 출력");
        Quiz2_1.prettyPrintApple(apples, (apple) ->
            apple.getWeight() > 150 ? "Heavy" : "No-Heavy"
        );
    }

    @Test
    public void 람다사용_리스트로_추상화_반환() {
        System.out.println("Test, filter메서드 구현결과를 리스트(Generic)로 추상화");
        List<Apple> redApples = Quiz2_1.filter(apples, (apple) -> Color.Red.equals(apple.getColor()));
        System.out.println("빨간사과 개수: " + redApples.size());

        List<Fruit> fruits = new ArrayList<Fruit>();
        fruits.addAll(apples);
        fruits.add(new Banana(Color.Yellow, 250));
        fruits.add(new Banana(Color.Yellow, 100));
        fruits.add(new Banana(Color.Green, 350));
        fruits.add(new Banana(Color.Blue, 150));
        fruits.add(new Banana(Color.Yellow, 210));
        List<Fruit> yellowBanana = Quiz2_1.filter(fruits, (banana) -> Color.Yellow.equals(banana.getColor()) && banana.getWeight() > 200);
        System.out.println("노랗고 무게가 200이 넘어가는 바나나 개수: " + yellowBanana.size());

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(80);
        numbers.add(70);
        numbers.add(20);
        numbers.add(100);
        numbers.add(90);
        List<Integer> highScores = Quiz2_1.filter(numbers, (score) -> score >= 80);
        System.out.println("80점 이상 점수를 받은 사람 수: " + highScores.size());
    }
}
