package ch02.quiz2_1;

public class AppleWeightPrinter implements ApplePrinter {
    @Override
    public String print(Apple apple) {
        StringBuilder sb = new StringBuilder();
        sb.append("weight:").append(apple.getWeight());
        return sb.toString();
    }
}
