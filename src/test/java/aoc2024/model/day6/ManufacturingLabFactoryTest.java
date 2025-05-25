package aoc2024.model.day6;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManufacturingLabFactoryTest {
    @Test
    public void whenCreateShouldBuildExpectedManufacturingLab() {
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

        var internalMap = new Character[][] {
                {'.','.','.','.','#','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.','#'},
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','.','#','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','#','.','.'},
                {'.','.','.','.','.','.','.','.','.','.'},
                {'.','#','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','#','.'},
                {'#','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','#','.','.','.'}
        };


        var expectedManufacturingLab = new ManufacturingLab(internalMap, Position.of(4, 6));

        var factory = new ManufacturingLabFactory();
        var manufacturingLab = factory.create(map);

        assertThat(manufacturingLab).isEqualTo(expectedManufacturingLab);
    }

    @Test
    public void whenCreateWithExtraObstacleShouldBuildExpectedManufacturingLab() {
        List<String> map = List.of(
                "#...",
                "...#",
                "....",
                "^.#."
        );

        var internalMap = new Character[][] {
                {'#','.','.','.'},
                {'O','.','.','#'},
                {'.','.','.','.'},
                {'.','.','#','.'},
        };

        var expectedManufacturingLab = new ManufacturingLab(internalMap, Position.of(0, 3));

        var factory = new ManufacturingLabFactory();
        var manufacturingLab = factory.createWithExtraObstacle(map, Position.of(0, 1));

        assertThat(manufacturingLab).isEqualTo(expectedManufacturingLab);
    }
}