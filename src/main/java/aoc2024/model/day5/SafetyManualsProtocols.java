package aoc2024.model.day5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class SafetyManualsProtocols {
    private final List<PageOrderingRule> rules;
    private final List<ManualUpdate> manualUpdates;

    public int getMiddlePageSumOfCorrectlyOrderedUpdates() {
        return manualUpdates.stream()
                .filter(manualUpdate -> manualUpdate.meetsAllRules(rules))
                .mapToInt(ManualUpdate::getMiddlePage)
                .sum();
    }

    public int getMiddlePageSumOfIncorrectlyOrderedUpdatesAfterCorrectingThem() {
        return manualUpdates.stream()
                .filter(manualUpdate -> !manualUpdate.meetsAllRules(rules))
                .map(manualUpdate -> ManualUpdateOrderCorrector.of(manualUpdate, rules))
                .map(ManualUpdateOrderCorrector::getCorrectlyOrderedManualUpdate)
                .mapToInt(ManualUpdate::getMiddlePage)
                .sum();
    }

    @Override
    public String toString() {
        return rules.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(System.lineSeparator())) +
            System.lineSeparator() +
            System.lineSeparator() +
            manualUpdates.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
