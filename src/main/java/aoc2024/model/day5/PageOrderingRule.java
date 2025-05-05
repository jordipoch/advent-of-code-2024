package aoc2024.model.day5;

public record PageOrderingRule(int beforePage, int afterPage) {

    public static PageOrderingRule of(int beforePage, int afterPage) {
        return new PageOrderingRule(beforePage, afterPage);
    }

    @Override
    public String toString() {
        return beforePage + "|" + afterPage;
    }
}
