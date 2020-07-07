package ch05;

import ch04.Dish;
import ch04.Menu;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSlicing {
    public static void main(String[] args) {
        System.out.println("onlyFilter..");
        onlyFilter();
        System.out.println("withTakeWhile..");
        withTakeWhile();
    }

    private static void onlyFilter() {
        Menu menu = new Menu();
        List<Dish> menus = menu.getMenus();
        System.out.println(menus.toString());
        List<Dish> filteredMenus = menus.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(filteredMenus.toString());
    }

    private static void withTakeWhile() {
        Menu menu = new Menu();
        List<Dish> menus = menu.getMenus();
        System.out.println(menus.toString());
       // List<Dish> filteredMenus = menus.stream()
      //          .takeWhile(Dish::getCalories);
    }
}
