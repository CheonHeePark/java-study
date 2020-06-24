package ch02.quiz2_1;

/**
 * 함수형 인터페이스
 * (정확히 하나의 추상 메서드만 지정하기 때문)
 * @param <T>
 */
@FunctionalInterface
public interface Predicate<T> {
    boolean accept(T t);
}
