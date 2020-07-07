package ch05;

import ch04.Dish;
import ch04.Menu;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
        System.out.println("모든 메뉴: " + menus.toString());
        List<Dish> filteredMenus = menus.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());
        System.out.println("320칼로리 미만의 메뉴: " + filteredMenus.toString());
    }

    private static void withTakeWhile() {
        Menu menu = new Menu();
        List<Dish> menus = menu.getMenus();
        System.out.println("모든메뉴: " + menus.toString());
        List<Dish> filteredMenus = menus.stream()
                .takeWhile(dish -> dish.getCalories() > 500)
                .collect(toList());
        System.out.println("500칼로리 이상의 메뉴: " + filteredMenus);
    }
}
