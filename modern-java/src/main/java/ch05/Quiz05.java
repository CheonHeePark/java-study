package ch05;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Quiz05 {
    public static void main(String[] args) {
        quiz5_2_1();
        quiz5_2_2();
        quiz5_2_3();
    }

    private static void quiz5_2_1() {
        System.out.println("Quiz 5-2 1");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> sqrts = numbers.stream()
                .map(x -> x * x)
                .collect(toList());
        System.out.println(numbers);
        System.out.println(sqrts);
    }

    private static void quiz5_2_2() {
        System.out.println("Quiz 5-2 2");
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);
        List<Integer[]> answers = numbers1.stream()
                //.map(i -> numbers2.stream().map(j -> new Integer[]{i, j}))
                // 위와같이 map 2중화를 통해 구현하려 한다면
                // 1. new Integer[]를 원소로 갖는 Stream<Integer[]> 가 반환된것을
                // 2. 한번더 Stream으로 감싼 Stream<Stream<Integer[]>>가 반환되므로 원하던 바가 아니다.
                // 따라서 flatMap을 사용하여 결과로 나온 원소들을 다시 하나의 스트림으로 묶어 Stream이중화가 되지 않도록 한다.
                .flatMap(i -> numbers2.stream().map(j -> new Integer[]{i, j}))
                .collect(toList())
                ;
        answers.stream().forEach(a -> System.out.print(Arrays.toString(a) + " "));
        System.out.println();
    }

    private static void quiz5_2_3() {
        System.out.println("Quiz 5-2 3");
        // 5_2_2에서 나온결과를 filter로 한번 걸러내서 (나누어 3으로 떨어지는 아이템만 필터링) 출력하면 된다.
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);
        /*
        List<Integer[]> beforeAnswers = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new Integer[]{i, j}))
                .collect(toList())
                ;
        List<Integer[]> answers = beforeAnswers.stream()
                .filter(item -> (item[0] + item[1]) % 3 == 0)
                .collect(toList());
        */
        // 변수하나 덜 사용해서 간략화해보기
        List<Integer[]> answers = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new Integer[]{i , j}))
                .filter(i -> (i[0] + i[1]) % 3 == 0)
                .collect(toList())
                ;
        answers.stream().forEach(a -> System.out.print(Arrays.toString(a) + " "));

    }
}
