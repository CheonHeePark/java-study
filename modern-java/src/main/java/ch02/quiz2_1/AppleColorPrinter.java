package ch02.quiz2_1;

public class AppleColorPrinter implements ApplePrinter {
    @Override
    public String print(Apple apple) {
        return apple.getColor().toString();
    }
}
