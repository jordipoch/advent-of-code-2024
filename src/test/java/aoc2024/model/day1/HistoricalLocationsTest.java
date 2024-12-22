package aoc2024.model.day1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HistoricalLocationsTest {

    @Test
    public void testCalculateDistanceWhenAlreadyOrdered() {
        var locations = HistoricalLocations.builder()
                .locationsList1(List.of(0, 3, 8))
                .locationsList2(List.of(1, 3, 7))
                .build();

        assertThat(locations.calculateDistance()).isEqualTo(2);
    }

    @Test
    public void testCalculateDistanceWhenNotOrdered() {
        var calculator = HistoricalLocations.builder()
                .locationsList1(List.of(8, 0, 3))
                .locationsList2(List.of(1, 7, 3))
                .build();

        assertThat(calculator.calculateDistance()).isEqualTo(2);
    }

    @Test(dataProvider = "data for similarity score calculation tests")
    public void whenCalculateSimilarityScoreShouldReturnExpectedScore(List<Integer> locationList1, List<Integer> locationList2, long expectedScore) {
        var locations = HistoricalLocations.builder()
                .locationsList1(locationList1)
                .locationsList2(locationList2)
                .build();

        assertThat(locations.calculateSimilarityScore()).isEqualTo(expectedScore);
    }

    @DataProvider(name = "data for similarity score calculation tests")
    protected Iterator<Object[]> getCalculateSimilarityScoreTestData() {
        return Arrays.asList(new Object[][] {
                {List.of(3), List.of(3), 3},
                {List.of(3), List.of(2), 0},
                {List.of(3), List.of(1, 3), 3},
                {List.of(3), List.of(1, 2), 0},
                {List.of(3), List.of(1, 3, 1, 3, 3, 4), 9},
                {List.of(3, 1, 2), List.of(4, 3, 1, 3, 3, 1), 11},
                {List.of(4, 1, 2, 5), List.of(4, 3, 1, 3, 4, 1, 5), 15},
        }).iterator();
    }
}