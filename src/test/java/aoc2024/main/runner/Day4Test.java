package aoc2024.main.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day4Test {

    @BeforeClass
    public void setUp() {
        Day4.createInjector();
    }

    @Test
    public void testPart1() {
        assertThat(Day4.runPart1()).isEqualTo(2718);
    }

    @Test
    public void testPart2() {
        assertThat(Day4.runPart2()).isEqualTo(2046);
    }
}