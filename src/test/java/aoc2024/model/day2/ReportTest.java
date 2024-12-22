package aoc2024.model.day2;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReportTest {

    @Test(dataProvider = "Safe levels test data")
    public void whenSafeLevelIsEvaluatedShouldReturnTrue(List<Integer> levelData) {
        var level = Report.builder()
                .levels(levelData)
                .build();

        Assertions.assertThat(level.isSafe()).isTrue();
    }

    @Test(dataProvider = "Unsafe levels test data")
    public void whenUnsafeLevelIsEvaluatedShouldReturnFalse(List<Integer> levelData) {
        var level = Report.builder()
                .levels(levelData)
                .build();

        Assertions.assertThat(level.isSafe()).isFalse();
    }

    @DataProvider(name = "Safe levels test data")
    private Iterator<Object[]> getSafeLevelsTestData() {
        return Arrays.asList(new Object[][] {
                {List.of(1, 2)},
                {List.of(1, 2, 4)},
                {List.of(1, 2, 4, 5)},
                {List.of(11, 9, 8, 7)},
                {List.of(12, 10, 8, 7, 5, 2, 1)},
        }).iterator();
    }

    @DataProvider(name = "Unsafe levels test data")
    private Iterator<Object[]> getUnsafeLevelsTestData() {
        return Arrays.asList(new Object[][] {
                {List.of(1, 1)},
                {List.of(1, 3, 2)},
                {List.of(1, 3, 6, 9, 8)},
                {List.of(10, 7, 6, 4, 4)},
                {List.of(1, 5, 6)},
                {List.of(1, 5, 16)},
                {List.of(10, 9, 6, 2, 0)},
                {List.of(10, 9, 1)},
                {List.of(10, 2, 1)},
        }).iterator();
    }
}