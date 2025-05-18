package aoc2024.main.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day6Test {

    @BeforeClass
    public void setUp() {
        BaseRunner.createInjector();
    }

    @Test
    public void testPart1() {
        assertThat(Day6.runPart1()).isEqualTo(5409);
    }
}