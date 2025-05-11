package aoc2024.main.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day5Test {

    @BeforeClass
    public void setUp() {
        BaseRunner.createInjector();
    }

    @Test
    public void testPart1() {
        assertThat(Day5.runPart1()).isEqualTo(4924);
    }

    @Test
    public void testPart2() {
        assertThat(Day5.runPart2()).isEqualTo(6085);
    }
}