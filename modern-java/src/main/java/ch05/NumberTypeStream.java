package ch05;

import ch04.Dish;
import ch04.Menu;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Ch 5-7
public class NumberTypeStream {
    public static void main(String[] args) {
        Menu menu = new Menu();
        List<Dish> menus = menu.getMenus();
        // 칼로리 합
        // map의 반환값이 Stream<Integer> 이므로 (Autoboxing) sum(); 과 같은 연산 불가
        // 따라서 기본형을 갖는 Stream이 필요함
        //int calories = menus.stream().map(Dish::getCalories).sum();
        int calories = menus.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("칼로리 합(Unbox): " + calories);
        // 다시 Boxing된 Stream으로 변환하려면
        Stream<Integer> boxedCalories = menus.stream().mapToInt(Dish::getCalories).boxed();
        System.out.println("칼로리 합(Boxed): " + boxedCalories.reduce(Integer::sum).get());

        Optional<Integer> maxCalories = menus.stream().map(Dish::getCalories).max(Integer::max);
        System.out.println("maxCalories(Boxed): " + maxCalories.get());
        OptionalInt maxCalories2 = menus.stream().mapToInt(Dish::getCalories).max();
        System.out.println("maxCalories(Unbox): " + maxCalories2.orElse(Integer.MAX_VALUE));

        // 1~100 중 짝수의 합
        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(number -> (number & 1) == 0);
        System.out.println("1~100 중 짝수의 합: " + evenNumbers.sum());
    }
}
