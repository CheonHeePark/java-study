package ch04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz04 {
    private static Menu menu = new Menu();
    private static List<Dish> menus = menu.getMenus();

    public static void main(String[] args) {
        quiz1();
        quiz2();
    }

    // 외부반복을 스트림을 사용하여 내부 반복으로 변경해보기
    private static void quiz1() {
        List<String> highCaloriesDishes = new ArrayList<>();
        Iterator<Dish> iterator = menus.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            if (dish.getCalories() > 300) {
                highCaloriesDishes.add(dish.getName());
            }
        }
        System.out.println("origin: " + highCaloriesDishes.toString());

        // Answer
        List<String> highCaloriesDishNames = menus.stream()
               .filter(dish -> dish.getCalories() > 300)
               .map(Dish::getName)
               .collect(Collectors.toList());
        System.out.println("answer: " + highCaloriesDishNames);
    }

    // 중간연산과 최종연산
    private static void quiz2() {
        long count = menus.stream()
                .filter(dish -> dish.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();
        System.out.println("중간연산: filter, distinct, limit");
        System.out.println("최종연산: count (3)");
    }
}
