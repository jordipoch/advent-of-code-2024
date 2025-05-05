package aoc2024.main.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day5Test {

    @BeforeClass
    public void setUp() {
        Day4.createInjector();
    }

    @Test
    public void testPart1() {
        assertThat(Day5.runPart1()).isEqualTo(4924);
    }
}