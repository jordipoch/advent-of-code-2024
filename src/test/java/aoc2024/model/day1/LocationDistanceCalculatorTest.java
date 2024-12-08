package aoc2024.model.day1;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationDistanceCalculatorTest {

    @Test
    public void testCalculateDistanceWhenAlreadyOrdered() {
        var calculator = LocationDistanceCalculator.builder()
                .locationsList1(List.of(0, 3, 8))
                .locationsList2(List.of(1, 3, 7))
                .build();

        assertThat(calculator.calculateDistance()).isEqualTo(2);
    }

    @Test
    public void testCalculateDistanceWhenNotOrdered() {
        var calculator = LocationDistanceCalculator.builder()
                .locationsList1(List.of(8, 0, 3))
                .locationsList2(List.of(1, 7, 3))
                .build();

        assertThat(calculator.calculateDistance()).isEqualTo(2);
    }
}