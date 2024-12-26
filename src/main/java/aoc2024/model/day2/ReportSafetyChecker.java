package aoc2024.model.day2;

import aoc2024.model.day2.result.SafetyResult;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ReportSafetyChecker {
    public boolean isReportSafeWithProblemDampener(Report report) {
        SafetyResult safetyResult = report.checkSafety();

        if (safetyResult.isSafe())
            return true;
        else {
            List<Report> alternativeReports = getAlternativeReports(report, safetyResult);
            return alternativeReports.stream()
                    .map(Report::checkSafety)
                    .anyMatch(SafetyResult::isSafe);
        }
    }

    private List<Report> getAlternativeReports(Report report, SafetyResult safetyResult) {
        List<Report> alternativeReports = new ArrayList<>();
        alternativeReports.add(report.cloneReportWithoutLevelAtIndex(safetyResult.getFirstLevel()));
        alternativeReports.add(report.cloneReportWithoutLevelAtIndex(safetyResult.getSecondLevel()));

        if (safetyResult.getFirstLevel() == 1) {
            alternativeReports.add(report.cloneReportWithoutLevelAtIndex(0));
        }

        return alternativeReports;
    }
}
