package aoc2024.main.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {

    @BeforeClass
    public void setUp() {
        Day1.createInjector();
    }

    @Test
    public void testPart1() {
        assertThat(Day1.runPart1()).isEqualTo(0);
    }

    @Test
    public void testPart2() {
        assertThat(Day1.runPart2()).isEqualTo(0);
    }
}