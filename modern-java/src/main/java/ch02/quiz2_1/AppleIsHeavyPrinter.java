package ch02.quiz2_1;

public class AppleIsHeavyPrinter implements ApplePrinter {
    @Override
    public String print(Apple apple) {
        return apple.getWeight() > 150 ? "Very heavy" : "No heavy";
    }
}
