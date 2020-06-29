package ch03.quiz3_6;

import ch02.quiz2_1.Fruit;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary.stringToInt;

/**
 * 람다 -> 메서드 참조
 * 람다 -> 생성자 참조
 */
public class Quiz3_6 {
    public static void main(String[] args) {
        ToIntFunction<String> stringToInt = (String s) -> Integer.parseInt(s);
        ToIntFunction<String> stringToInt2 = Integer::parseInt;
        int answer1 = stringToInt("100");
        int answer2 = stringToInt2.applyAsInt("200");
        System.out.println(answer1 + " / " + answer2);

        BiPredicate<List<String>, String> contains  = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains2 = List::contains;

        Supplier<Fruit> s1 = () -> new Fruit();
        Fruit sa1 = s1.get();
        System.out.println(sa1.getWeight());
        Supplier<Fruit> s2 = Fruit::new;
        Fruit sa2 = s2.get();
        System.out.println(sa2.getWeight());

        Function<Integer, String> f1 = (idx) -> new String(String.valueOf(idx));
        String fa1 = f1.apply(1000);
        System.out.println(fa1);
        Function<Integer, Fruit> f2 = Fruit::new;
        Fruit fa2 = f2.apply(2000);
        System.out.println(fa2.getWeight());
    }
}
