package aoc2024.model.day2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportTest {

    @Test(dataProvider = "Safe reports test data")
    public void whenSafeReportIsEvaluatedShouldReturnTrue(Report report) {
        assertThat(report.checkSafety().isSafe()).isTrue();
    }

    @Test(dataProvider = "Unsafe reports test data")
    public void whenUnsafeReportIsEvaluatedShouldReturnFalse(Report report) {
        assertThat(report.checkSafety().isSafe()).isFalse();
    }

    @Test(dataProvider = "Report clone test data")
    public void whenReportIsClonedWithoutLevelShouldContainExpectedLevels(Report original, int index, Report expectedClone) {
        assertThat(original.cloneReportWithoutLevelAtIndex(index))
                .isEqualTo(expectedClone);
    }

    @DataProvider(name = "Safe reports test data")
    private Iterator<Object[]> getSafeReportsTestData() {
        return Arrays.asList(new Object[][] {
                {Report.of(1, 2)},
                {Report.of(1, 2, 4)},
                {Report.of(1, 2, 4, 5)},
                {Report.of(11, 9, 8, 7)},
                {Report.of(12, 10, 8, 7, 5, 2, 1)},
        }).iterator();
    }

    @DataProvider(name = "Unsafe reports test data")
    private Iterator<Object[]> getUnsafeReportsTestData() {
        return Arrays.asList(new Object[][] {
                {Report.of(1, 1)},
                {Report.of(1, 3, 2)},
                {Report.of(1, 3, 6, 9, 8)},
                {Report.of(10, 7, 6, 4, 4)},
                {Report.of(1, 5, 6)},
                {Report.of(1, 5, 16)},
                {Report.of(10, 9, 6, 2, 0)},
                {Report.of(10, 9, 1)},
                {Report.of(10, 2, 1)},
        }).iterator();
    }

    @DataProvider(name = "Report clone test data")
    private Iterator<Object[]> getReportCloneTestData() {
        return Arrays.asList(new Object[][] {
                {Report.of(1, 2, 3), 0, Report.of(2, 3)},
                {Report.of(1, 2, 3), 1, Report.of(1, 3)},
                {Report.of(1, 2, 3), 2, Report.of(1, 2)},
                {Report.of(1), 0, Report.of()},
        }).iterator();
    }
}