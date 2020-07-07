package ch05;

import ch04.Dish;
import ch04.Menu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Mapping {
    public static void main(String[] args) {
        Menu menu = new Menu();
        List<Dish> menus = menu.getMenus();
        List<String> dishNames = menus.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println("DishName: " + dishNames.toString());

        List<Integer> dishNameLengths = menus.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println("DishNameLength: " + dishNameLengths);

        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> mappedWords = words.stream()
                // String.split의 반환타입이 String[]이므로, 애초 원했던 List<String>의 형태가 아니다.
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        for (String[] arr : mappedWords) {
            System.out.println("Mapped Words-Item: " + Arrays.toString(arr));
        }

        /* flatMap: 각 배열을 스트림이 아니라 스트림의 컨텐츠로 변환한다.
         * map과정에서 split된 String[]을 Stream 형태로 변환한 Stream<String[]>이 출력되고
         * flatMap과정에서 Stream<String>으로 변환되어 출력된다.
         * 즉 flatMap은 스트림의 각 원소들을 또다른 스트림으로 변환하고, (Stream<String[]> -> Stream<String>, Stream<String>, Stream<String>, ...)
         * 모든 스트림을 하나의 스트림으로 연결하여 반환한다. (... -> Stream<String>)
         */
        List<String> mappedWords2 = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println("Mapped Words: " + mappedWords2);
    }
}
