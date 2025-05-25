package aoc2024.model.day6;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

        manufacturingLab.simulateGuardWalking();
        int positions = manufacturingLab.getNumPositionsVisited();
        assertThat(positions).isEqualTo(7);
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

        manufacturingLab.simulateGuardWalking();
        int positions = manufacturingLab.getNumPositionsVisited();
        assertThat(positions).isEqualTo(41);
    }

    @Test
    public void whenSimulationIsRanGetPositionsVisitedShouldReturnExpectedPositionsInOrder() {
        List<String> map = List.of(
                "#...",
                "...#",
                "....",
                "^.#."
        );

        var manufacturingLab = factory.create(map);
        manufacturingLab.simulateGuardWalking();
        var positionsVisited = manufacturingLab.getPositionsVisited();

        assertThat(positionsVisited).containsExactly(
                Position.of(0, 3),
                Position.of(0, 2),
                Position.of(0, 1),
                Position.of(1, 1),
                Position.of(2, 1),
                Position.of(2, 2),
                Position.of(1, 2)
        );
    }

    @Test
    public void whenTheresALoopShouldDetectThatLoopAndStop() {
        List<String> map = List.of(
                ".#...",
                "....#",
                ".....",
                "#....",
                ".^#.."
        );

        var manufacturingLab = factory.createWithExtraObstacle(map, Position.of(3, 4));
        manufacturingLab.simulateGuardWalking();
        assertThat(manufacturingLab.isLoopDetected()).isTrue();
    }
}