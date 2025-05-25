package aoc2024.model.day6;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManufacturingLabSimulatorTest {

    @Test
    public void testSimpleScenario() {
        List<String> map = List.of(
                ".#...",
                "....#",
                ".....",
                "#....",
                ".^#.."
        );

        var manufacturingLabSimulator = new ManufacturingLabSimulator(map, new ManufacturingLabFactory());
        int numPositions = manufacturingLabSimulator.countNumberOfPositionsWhereTheObstructionCausesALoop();

        assertThat(numPositions).isEqualTo(2);
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

        var manufacturingLabSimulator = new ManufacturingLabSimulator(map, new ManufacturingLabFactory());
        int numPositions = manufacturingLabSimulator.countNumberOfPositionsWhereTheObstructionCausesALoop();

        assertThat(numPositions).isEqualTo(6);
    }
}