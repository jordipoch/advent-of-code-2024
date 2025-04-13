package aoc2024.main.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3Test {

    @BeforeClass
    public void setUp() {
        Day2.createInjector();
    }

    @Test
    public void testPart1() {
        assertThat(Day3.runPart1()).isEqualTo(179571322);
    }

    @Test
    public void testPart2() {
        assertThat(Day3.runPart2()).isEqualTo(103811193);
    }
}