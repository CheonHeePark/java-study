package ch02.quiz2_1;

import java.util.ArrayList;
import java.util.List;

public class Quiz2_1 {
    /**
     * printer에 구현에 따라 출력할 결과가 달라진다.
     * @param inventory 사과 목록
     * @param printer 동적 파라미터화를 위한 인터페이스
     */
    public static void prettyPrintApple(List<Apple> inventory, ApplePrinter printer) {
        for (Apple apple : inventory) {
            String output = printer.print(apple);
            System.out.println(output);
        }
    }

    public static <Fruit>List<Fruit> filter(List<Fruit> inventory, Predicate<Fruit> predicate) {
        List<Fruit> results = new ArrayList<>();
        for (Fruit t : inventory) {
            if (predicate.accept(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public static void main(String[] args) {
    }
}
