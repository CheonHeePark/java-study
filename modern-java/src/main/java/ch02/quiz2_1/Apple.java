package ch02.quiz2_1;

import lombok.Getter;

@Getter
public class Apple extends Fruit {
    public Apple(Color color, int weight) {
        super(color, weight);
    }
}
