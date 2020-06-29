package ch02.quiz2_1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {
    private Color color;
    private int weight;

    public Fruit(Integer weight) {
        this.weight = weight;
    }
}
