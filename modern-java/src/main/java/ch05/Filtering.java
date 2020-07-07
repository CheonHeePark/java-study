package ch05;

import ch04.Dish;
import ch04.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Filtering {
    public static void main(String[] args) {
        filteringWithPredicate();
        filteringWithDistinct();
    }

    private static void filteringWithPredicate() {
        Menu menu = new Menu();
        List<Dish> menus = menu.getMenus();

        List<Dish> vegetarianMenu = menus.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        System.out.println("Vegetable menus: " + vegetarianMenu.toString());
    }

    private static void filteringWithDistinct() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,1,2,3,4);
        List<Integer> targets = numbers.stream()
                .filter(number -> number < 3)
                .distinct()
                .collect(toList());
        System.out.println("Smaller than 3 numbers: " + targets.toString());
    }
}
