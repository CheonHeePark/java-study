package ch04;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Menu {
    private List<Dish> menus;

    public Menu() {
        createMenu();
    }

    private void createMenu() {
        menus = new ArrayList<>();
        menus.add(new Dish("pork", false, 800, Dish.Type.MEAT));
        menus.add(new Dish("beef", false, 700, Dish.Type.MEAT));
        menus.add(new Dish("chicken", false, 400, Dish.Type.MEAT));
        menus.add(new Dish("french fries", true, 530, Dish.Type.OTHER));
        menus.add(new Dish("rice", true, 350, Dish.Type.OTHER));
        menus.add(new Dish("season fruit", true, 120, Dish.Type.OTHER));
        menus.add(new Dish("pizza", true, 550, Dish.Type.OTHER));
        menus.add(new Dish("prawns", false, 300, Dish.Type.FISH));
        menus.add(new Dish("salmon", false, 450, Dish.Type.FISH));
    }
}
