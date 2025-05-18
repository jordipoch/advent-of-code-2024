package aoc2024.main.runner;

public class AllDaysRunner extends BaseRunner {
    public static void main(String... args) {
        createInjector();

        Day1.run();
        Day2.run();
        Day3.run();
        Day4.run();
        Day5.run();
        Day6.run();
    }
}
