package ch04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 전체 메뉴 중에서 칼로리가 높은 순서대로 3개 메뉴의 이름을 리스트로 가져오기
 */
public class Exam04 {
    public static void main(String[] args) {
        Menu menu = new Menu();
        List<Dish> menus = menu.getMenus();
        exam04_1(menus);
    }

    private static void exam04_1(List<Dish> menus) {
        // java8 stream 사용
        exam1TryJava8(menus);
        // 만약 java8 이전이라면 아래와 같이 해야 했을 듯
        exam1TryJava7(menus);
    }

    private static void exam1TryJava8(List<Dish> menus) {
         List<String> threeHighCaloriesDishNames =
                menus.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .sorted(Comparator.comparing(Dish::getCalories).reversed())
                        .map(Dish::getName)
                        .limit(3)
                        .collect(Collectors.toList());
        System.out.println("tryJava8: " + threeHighCaloriesDishNames);
    }

    private static void exam1TryJava7(List<Dish> menus) {
        List<Dish> highCaloriesDishes = new ArrayList<Dish>();
        for (Dish dish: menus) {
           if (dish.getCalories() > 300) highCaloriesDishes.add(dish);
        }
        highCaloriesDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                if (o1.getCalories() < o2.getCalories()) return 1;
                else if (o1.getCalories() > o2.getCalories()) return -1;
                return 0;
            }
        });
        List<String> dishNames = new ArrayList<String>();
        for (Dish dish : highCaloriesDishes) {
           dishNames.add(dish.getName());
           if (dishNames.size() == 3) break;
        }
        System.out.println("tryJava7: " + dishNames);
    }
}
