package aoc2024.model.day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportSafetyCheckerTest {
    private final ReportSafetyChecker reportSafetyChecker = new ReportSafetyChecker();

    @Test
    public void whenSafeReportShouldReturnTrue() {
        var report = Report.builder()
                .levels(List.of(1, 2, 3, 4))
                .build();

        assertThat(reportSafetyChecker.isReportSafeWithProblemDampener(report)).isTrue();
    }

    @Test(dataProvider = "Unsafe reports with one bad level")
    public void whenUnsafeReportWithOneBadLevelShouldReturnTrue(Report report) {
        assertThat(reportSafetyChecker.isReportSafeWithProblemDampener(report)).isTrue();
    }

    @Test(dataProvider = "Unsafe reports with more than one bad level")
    public void whenUnsafeReportWithMoreThanOneBadLevelsShouldReturnFalse(Report report) {
        assertThat(reportSafetyChecker.isReportSafeWithProblemDampener(report)).isFalse();
    }

    @DataProvider(name = "Unsafe reports with one bad level")
    private Iterator<Object[]> getUnsafeReportsWithOneBadLevelTestData() {
        return Arrays.asList(new Object[][] {
                {Report.of(1, 2, 3, 14, 6)},
                {Report.of(1, 2, 3, 6, 14)},
                {Report.of(1, 2, 3, 6, 5)},
                {Report.of(1, 5, 6, 7, 8)},
                {Report.of(8, 5, 6, 7, 8)},
                {Report.of(3, 5, 10, 7, 8)},
                {Report.of(8, 5, 10, 12, 15)},
                {Report.of(1, 2, 4, 3, 7)}
        }).iterator();
    }

    @DataProvider(name = "Unsafe reports with more than one bad level")
    private Iterator<Object[]> getUnsafeReportsWithMoreThanOneBadLevelTestData() {
        return Arrays.asList(new Object[][] {
                {Report.of(8, 2, 3, 14, 6)},
                {Report.of(10, 7, 8, 4, 6)},
        }).iterator();
    }
}