package aoc2024.model.day2;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UnusualDataTest {
    private final UnusualData unusualData = UnusualData.builder()
            .reportSafetyChecker(new ReportSafetyChecker())
            .reports(List.of(
            Report.builder().levels(List.of(1, 3, 6, 7, 10)).build(), // safe
                     Report.builder().levels(List.of(7, 7, 9, 10, 12)).build(), // unsafe
                     Report.builder().levels(List.of(7, 6, 4, 1, 0)).build(), // safe
                     Report.builder().levels(List.of(7, 6, 4, 5, 3, 1)).build() // unsafe
                ))
                        .build();

    @Test
    public void whenUnusualDataIsAnalyzedShouldReturnExpectedNumOfSafeReports() {
        assertThat(unusualData.getNumSafeReports()).isEqualTo(2);
    }

    @Test
    public void whenUnusualDataIsAnalyzedWithProblemDampenerShouldReturnExpectedNumOfSafeReports() {
        assertThat(unusualData.getNumSafeReportsToleratingOneBadLevel()).isEqualTo(4);
    }
}