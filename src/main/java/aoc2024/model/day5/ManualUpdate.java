package aoc2024.model.day5;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class ManualUpdate {
    private final List<Integer> pages;

    public static ManualUpdate of(List<Integer> pages) {
        return new ManualUpdate(pages);
    }

    public ManualUpdate(List<Integer> pages) {
        this.pages = pages;
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

    public int getPageIndex(int page) {
        return pages.indexOf(page);
    }

    @Override
    public String toString() {
        return pages.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(" "));
    }
}
