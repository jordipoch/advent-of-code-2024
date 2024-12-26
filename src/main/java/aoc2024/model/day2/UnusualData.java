package aoc2024.model.day2;

import aoc2024.model.day2.result.SafetyResult;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UnusualData {
    private final List<Report> reports;
    private ReportSafetyChecker reportSafetyChecker;

    public int getNumSafeReports() {
        return (int) reports.stream()
                .map(Report::checkSafety)
                .filter(SafetyResult::isSafe)
                .count();
    }

    public int getNumSafeReportsToleratingOneBadLevel() {
        return (int) reports.stream()
                .filter(report -> reportSafetyChecker.isReportSafeWithProblemDampener(report))
                .count();
    }
}
