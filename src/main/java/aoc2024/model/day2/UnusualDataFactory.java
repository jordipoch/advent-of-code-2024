package aoc2024.model.day2;

import aoc2024.library.string.StringUtils;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UnusualDataFactory {
    private final ReportSafetyChecker reportSafetyChecker;

    @Inject
    public UnusualDataFactory(ReportSafetyChecker reportSafetyChecker) {
        this.reportSafetyChecker = reportSafetyChecker;
    }

    public UnusualData create(List<String> rawData) {
        List<Report> reports = rawData.stream()
                .map(this::createLevelList)
                .map(this::createReport)
                .toList();

        return UnusualData.builder()
                .reports(reports)
                .reportSafetyChecker(reportSafetyChecker)
                .build();
    }

    private List<Integer> createLevelList(String s) {
        return StringUtils.split(s, "\\s+").stream()
                .map(Integer::parseInt)
                .toList();
    }

    private Report createReport(List<Integer> vectorList) {
        return Report.builder().levels(vectorList).build();
    }
}
