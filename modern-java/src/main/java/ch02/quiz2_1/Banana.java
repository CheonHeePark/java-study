package ch02.quiz2_1;

import lombok.Getter;

@Getter
public class Banana extends Fruit {
    public Banana(Color color, int weight) {
        super(color, weight);
    }
}
