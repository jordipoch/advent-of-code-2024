package aoc2024.model.day1;

import aoc2024.library.string.StringUtils;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class LocationDistanceCalculatorFactory {
    public LocationDistanceCalculator create(List<String> combinedLocations) {
        List<Integer> locationsList1 = new ArrayList<>();
        List<Integer> locationsList2 = new ArrayList<>();

        for (String e : combinedLocations) {
            var locationPair = StringUtils.split(e, "\\s+");
            locationsList1.add(Integer.parseInt(locationPair.get(0)));
            locationsList2.add(Integer.parseInt(locationPair.get(1)));
        }

        return LocationDistanceCalculator.builder()
                .locationsList1(locationsList1)
                .locationsList2(locationsList2)
                .build();
    }
}
