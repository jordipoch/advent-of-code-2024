package aoc2024.model.day1;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationDistanceCalculatorFactoryTest {

    @Test
    public void testCreate() {
        var factory = new LocationDistanceCalculatorFactory();
        var instance = factory.create(List.of("1 0", "3   2", "1    5"));

        assertThat(instance.getLocationsList1()).containsExactly(1, 3, 1);
        assertThat(instance.getLocationsList2()).containsExactly(0, 2, 5);
    }
}