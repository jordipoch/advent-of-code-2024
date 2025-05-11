package aoc2024.model.day5;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class ManualUpdate {
    private final List<Integer> pages;

    public static ManualUpdate of(List<Integer> pages) {
        return new ManualUpdate(pages);
    }

    public ManualUpdate(List<Integer> pages) {
        this.pages = new ArrayList<>(pages);
    }

    public boolean meetsAllRules(List<PageOrderingRule> rules) {
        return rules.stream().allMatch(this::meetsRule);
    }

    public boolean meetsRule(PageOrderingRule rule) {
        var beforePageIndex = pages.indexOf(rule.beforePage());
        var afterPageIndex = pages.indexOf(rule.afterPage());

        if (beforePageIndex == -1 || afterPageIndex == -1)
            return true;

        return beforePageIndex < afterPageIndex;
    }

    public int getMiddlePage() {
        return pages.get(pages.size() / 2);
    }

    public List<PageOrderingRule> getRulesNotMet(List<PageOrderingRule> rules) {
        return rules.stream()
                .filter(Predicate.not(this::meetsRule))
                .toList();
    }

    public ManualUpdate makeRuleMeet(PageOrderingRule rule) {
        if (meetsRule(rule))
            throw new IllegalArgumentException("Manual update already meets the rule");

        var reorderedPages = new LinkedList<>(pages);

        var beforePageIndex = getAndCheckPageIndex(rule.beforePage());
        var afterPageIndex = getAndCheckPageIndex(rule.afterPage());

        reorderedPages.remove(beforePageIndex);
        reorderedPages.add(afterPageIndex, rule.beforePage());

        return ManualUpdate.of(reorderedPages);
    }

    private int getAndCheckPageIndex(int page) {
        var index = pages.indexOf(page);
        if (index == -1) {
            throw new IllegalArgumentException(String.format("Page %d doesn't exist in manual update %s", page, this));
        }

        return index;
    }

    @Override
    public String toString() {
        return pages.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }
}
