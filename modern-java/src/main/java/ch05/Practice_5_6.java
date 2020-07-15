package ch05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Practice_5_6 {
    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario", "Milan");
    static Trader alan  = new Trader("Alan",  "Cambridge");
    static Trader brian = new Trader("Brian", "Cambridge");

    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan,  2012, 950)
    );

    public static void main(String[] args) {
        problem_1();
        problem_2();
        problem_3();
        problem_4();
        problem_5();
        problem_6();
        problem_7();
        problem_8();
    }

    // 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정렬
    private static void problem_1() {
        System.out.println("\nProblem1");
        List<Transaction> answer = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList())
                ;
        System.out.println(answer.toString());
    }

    // 거래자가 근무하는 모든 도시를 중복없이 나열
    private static void problem_2() {
        System.out.println("\nProblem2");
        List<String> answer =
                transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
        ;
        System.out.println(answer.toString());
    }

    // 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬
    private static void problem_3() {
        System.out.println("\nProblem3");
        List<Trader> answer =
                transactions.stream()
                        .map(transaction -> transaction.getTrader())
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(Collectors.toList());
        System.out.println(answer.toString());
    }

    // 모든 거래자의 이름을 알파벳순으로 정렬
    private static void problem_4() {
        System.out.println("\nProblem4");
        String answer = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + b + " ")
                ;
        System.out.println(answer.toString());

        List<String> answer2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(answer2.toString());
    }

    // 밀라노에 거래자가 있는가?
    private static void problem_5() {
        System.out.println("\nProblem5");
        boolean answer =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .anyMatch(city -> city.equals("Milan"));
        System.out.println(answer);
    }

    // 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력
    private static void problem_6() {
        System.out.println("\nProblem6");
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                //.map(transaction -> transaction.getValue())
                .map(Transaction::getValue)
                .forEach(transactions -> System.out.println(transactions.toString()));
    }

    // 전체 트랜잭션 중 최대값은?
    private static void problem_7() {
        System.out.println("\nProblem7");
        Optional<Integer> answer = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(answer);
    }

    // 전체 트랜잭션 중 최소값은?
    private static void problem_8() {
        System.out.println("\nProblem8");
        Optional<Integer> answer = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println(answer);
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::min).get());
    }
}
