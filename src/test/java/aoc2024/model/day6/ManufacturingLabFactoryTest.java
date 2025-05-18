package aoc2024.model.day6;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

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
                {'.','#','.','.','^','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','#','.'},
                {'#','.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','#','.','.','.'}
        };
        var expectedManufacturingLab = new ManufacturingLab(internalMap);

        var factory = new ManufacturingLabFactory();
        var manufacturingLab = factory.create(map);

        Assertions.assertThat(manufacturingLab).isEqualTo(expectedManufacturingLab);
    }
}