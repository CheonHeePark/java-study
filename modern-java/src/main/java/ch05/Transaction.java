package ch05;

import lombok.Getter;

@Getter
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + this.trader + "l, " +
                "year:" + this.year + ", " +
                "value:" + this.value + "}";

    }
}
