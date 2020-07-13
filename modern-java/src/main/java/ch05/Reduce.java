package ch05;

import ch04.Dish;
import ch04.Menu;

import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {
        quiz5_3_1();
    }

    private static void quiz5_3_1() {
        Menu menu = new Menu();
        List<Dish> menus = menu.getMenus();
        int count =
        menus.stream().map(dish -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(count);

        Optional<Integer> c =
                menus.stream().map(dish -> 1)
                .reduce( Integer::sum);
        System.out.println(c.get());

        int sumCalories = menus.stream()
                .map(dish -> dish.getCalories())
                .reduce(0, Integer::sum)
                ;
        System.out.println("Sum calories: " + sumCalories);
    }
}
