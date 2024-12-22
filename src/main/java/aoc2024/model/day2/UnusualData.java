package aoc2024.model.day2;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UnusualData {
    private final List<Report> reports;

    public int getNumSafeReports() {
        return (int) reports.stream()
                .filter(Report::isSafe)
                .count();
    }
}
