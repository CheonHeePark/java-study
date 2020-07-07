package ch05;

import ch04.Dish;
import ch04.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SelectingAndMatching {
    public static void main(String[] args) {
        Menu menu = new Menu();
        List<Dish> menus = menu.getMenus();
        // anyMatch: boolean 반환 (스트림에서 함수에 정의된 내용에 일치하는게 하나라도 있다면..)
        if (menus.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("채식 음식이 한 개 이상 존재합니다. ");
        }

        if (menus.stream().allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("모든 음식은 1000 칼로리를 넘지 않습니다.");
        }

        Optional<Dish> dishes = menus.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                ;
        System.out.println(dishes.toString());

        // 채식요리 중 임의의 한 요리를 이름을 출력한다.
        menus.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()))
                ;
    }
}
