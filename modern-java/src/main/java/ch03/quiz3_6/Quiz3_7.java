package ch03.quiz3_6;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Quiz3_7 {
    @AllArgsConstructor
    @Getter
    // 테스트를 위한 클래스
    static class Color {
        private Integer a, b, c;
    }

    // 인자 3개이상을 갖는 함수형 인터페이스가 기본적으로 제공되지 않으므로 별도로 구현
    interface Parameter3Interface {
       Color create(Integer a, Integer b, Integer c) ;
    }

    public static void main(String[] args) {
        // 3개의 인자를 갖는 Color의 생성자를 람다로 구현
        Parameter3Interface p1 = (a, b, c) -> new Color(a, b, c);
        Color c1 = p1.create(100, 200, 300);
        System.out.println("c1 : " + c1.getA() + " / " + c1.getB() + " / " + c1.getC());

        // 3개의 인자를 갖는 Color의 생성자 참조로 구현
        Parameter3Interface p2 = Color::new;
        Color c2 = p2.create(1000, 2000, 3000);
        System.out.println("c2 : " + c2.getA() + " / " + c2.getB() + " / " + c2.getC());
    }
}
