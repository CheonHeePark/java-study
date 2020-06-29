package ch03.exam03_7;

import ch02.quiz2_1.Apple;
import ch02.quiz2_1.Color;

import java.util.*;

public class Exam03_7 {
    private static void try1(List<Apple> inventory) {
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });
        print(inventory);
    }

    private static void try2(List<Apple> inventory) {
        inventory.sort((Apple a, Apple b) -> Integer.compare(a.getWeight(), b.getWeight()));
        print(inventory);
    }

    private static void try3(List<Apple> inventory) {
        // Comparator.comparing은 함수형 인터페이스인 Comparable을 참조
        // comparing 메서드의 파라미터가 함수형 인터페이스 Comparable의 메서드(compareTo)를 완전히 구현하였으므로 람다로 대체 가능
        Comparator<Apple> c = Comparator.comparing(a -> a.getWeight());
        inventory.sort(c);
        print(inventory);
    }

    private static void try4(List<Apple> inventory) {
        // 람다를 메서드 참조로 변경
        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
        inventory.sort(c);
        print(inventory);
    }

    private static void print(List<Apple> inventory) {
        for (Apple a : inventory) {
            System.out.print(a.getWeight() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 목표 : inventory.sort(comparing(Apple::getWeight));

        ArrayList<Apple> inventory = new ArrayList<Apple>();
        inventory.add(new Apple(Color.Red, 300));
        inventory.add(new Apple(Color.Red, 200));
        inventory.add(new Apple(Color.Red, 500));
        inventory.add(new Apple(Color.Red, 100));

        // try1. 익명 클래스로 구현
        try1(inventory);
        Collections.reverse(inventory);

        // try2. 람다로 구현
        try2(inventory);
        Collections.reverse(inventory);

        // try3. Comparator.comparing + 람다 구현
        try3(inventory);
        Collections.reverse(inventory);

        // try4. 메서드 참조로 구현
        try4(inventory);
    }
}
