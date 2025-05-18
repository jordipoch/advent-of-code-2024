package aoc2024.model.day6;

import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ManufacturingLabTest {
    private ManufacturingLabFactory factory;

    @BeforeMethod
    public void setUp() {
        factory = new ManufacturingLabFactory();
    }

    @Test
    public void testSimpleScenario() {
        List<String> map = List.of(
                "#...",
                "...#",
                "....",
                "^.#."
        );

        var manufacturingLab = factory.create(map);

        int positions = manufacturingLab.calculateNumberOfDifferentPositionsWalkedByTheGuard();
        Assertions.assertThat(positions).isEqualTo(7);
    }

    @Test
    public void testComplexScenario() {
        List<String> map = List.of(
            "....#.....",
            ".........#",
            "..........",
            "..#.......",
            ".......#..",
            "..........",
            ".#..^.....",
            "........#.",
            "#.........",
            "......#..."



        );

        var manufacturingLab = factory.create(map);

        int positions = manufacturingLab.calculateNumberOfDifferentPositionsWalkedByTheGuard();
        Assertions.assertThat(positions).isEqualTo(41);
    }
}