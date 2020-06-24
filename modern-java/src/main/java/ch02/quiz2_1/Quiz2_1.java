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

    /**
     * inventory로부터 predicate에 해당하는 요소들을 리스트로 반환한다.
     * @param inventory 입력으로 들어온 리스트
     * @param predicate 조건을 추상화한 인터페이스
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> inventory, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        for (T t : inventory) {
            if (predicate.accept(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public static void main(String[] args) {
    }
}
