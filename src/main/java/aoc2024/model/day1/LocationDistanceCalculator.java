package aoc2024.model.day1;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Builder
public class LocationDistanceCalculator {
    private List<Integer> locationsList1;
    private List<Integer> locationsList2;

    public int calculateDistance() {
        // Pre-condition: both lists have the same length

        var sortedLocationsList1 = sortLocations(locationsList1);
        var sortedLocationsList2 = sortLocations(locationsList2);

        int distance = 0;
        for (int i = 0; i < sortedLocationsList1.size(); i++)
            distance += Math.abs(sortedLocationsList1.get(i) - sortedLocationsList2.get(i));

        return distance;
    }

    private ArrayList<Integer> sortLocations(List<Integer> locations) {
        var sortedLocations = new ArrayList<>(locations);
        sortedLocations.sort(Comparator.naturalOrder());
        return sortedLocations;
    }
}
