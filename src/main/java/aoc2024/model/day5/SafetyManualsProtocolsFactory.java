package aoc2024.model.day5;

import aoc2024.library.string.StringUtils;

import java.util.List;

public class SafetyManualsProtocolsFactory {
    private static final String BLANK_LINE = "";
    private static final String RULE_SEPARATOR = "\\|";
    private static final String PAGE_SEPARATOR = ",";


    public SafetyManualsProtocols create(List<String> data) {
        return SafetyManualsProtocols.builder()
                .rules(createRules(data))
                .manualUpdates(createManualUpdates(data))
                .build();
    }

    private List<PageOrderingRule> createRules(List<String> data) {
        int separatorIndex = data.indexOf(BLANK_LINE);
        var ruleData = data.subList(0, separatorIndex);

        return ruleData.stream()
                .map(rule -> StringUtils.split(rule, RULE_SEPARATOR))
                .map(rule -> rule.stream().map(Integer::parseInt).toList())
                .map(rule -> PageOrderingRule.of(rule.get(0), rule.get(1)))
                .toList();
    }

    private List<ManualUpdate> createManualUpdates(List<String> data) {
        int separatorIndex = data.indexOf(BLANK_LINE);
        var manualUpdatesData = data.subList(separatorIndex + 1, data.size());
        return manualUpdatesData.stream()
                .map(manualUpdate -> StringUtils.split(manualUpdate, PAGE_SEPARATOR))
                .map(manualUpdate -> manualUpdate.stream().map(Integer::parseInt).toList())
                .map(ManualUpdate::of)
                .toList();
    }
}
