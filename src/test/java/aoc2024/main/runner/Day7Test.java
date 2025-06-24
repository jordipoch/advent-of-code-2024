package aoc2024.main.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day7Test {

    @BeforeClass
    public void setUp() {
        BaseRunner.createInjector();
    }

    @Test
    public void testPart1() {
        assertThat(Day7.runPart1()).isEqualTo(7_579_994_664_753L);
    }
}