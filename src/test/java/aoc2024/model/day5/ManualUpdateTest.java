package aoc2024.model.day5;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ManualUpdateTest {

    @Test(dataProvider = "getBothPagesExistScenarioTestDataForMakeRuleMeet")
    public void givenBothPagesExistAndAreInTheWrongOrderMoveBeforeShouldMakeRuleMeetAfterPage(List<Integer> originalPages, PageOrderingRule rule, List<Integer> expectedUpdatedPages) {
        var manualUpdate = ManualUpdate.of(originalPages);

        Assertions.assertThat(manualUpdate.makeRuleMeet(rule)).isEqualTo(ManualUpdate.of(expectedUpdatedPages));
    }

    @DataProvider
    private Iterator<Object[]> getBothPagesExistScenarioTestDataForMakeRuleMeet() {
        return Arrays.asList(new Object[][] {
                {List.of(1, 3, 2, 4), PageOrderingRule.of(2, 3), List.of(1, 2, 3, 4)},
                {List.of(1, 2), PageOrderingRule.of(2, 1), List.of(2, 1)},
                {List.of(1, 2, 3, 4), PageOrderingRule.of(4, 1), List.of(4, 1, 2, 3)},
        }).iterator();
    }

    @Test(dataProvider = "getNotBothPagesExistScenarioTestDataForMakeRuleMeet", expectedExceptions = IllegalArgumentException.class)
    public void givenNotBothPagesExistWhenMakeRuleMeetThenShouldThrowIllegalStateException(List<Integer> originalPages, PageOrderingRule rule) {
        var manualUpdate = ManualUpdate.of(originalPages);

        manualUpdate.makeRuleMeet(rule);
    }

    @DataProvider
    private Iterator<Object[]> getNotBothPagesExistScenarioTestDataForMakeRuleMeet() {
        return Arrays.asList(new Object[][] {
                {List.of(1, 2, 3, 4), PageOrderingRule.of(5, 3)},
                {List.of(1, 2, 3, 4), PageOrderingRule.of(1, 5)},
                {List.of(1, 2, 3, 4), PageOrderingRule.of(5, 6)},
        }).iterator();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void givenPagesAlreadyInTheRightOrderWhenMakeRuleMeetThenShouldThrowIllegalStateException() {
        var manualUpdate = ManualUpdate.of(List.of(1, 2, 3, 4));

        manualUpdate.makeRuleMeet(PageOrderingRule.of(1, 2));
    }

    @DataProvider
    private Iterator<Object[]> getPagesAlreadyInTheRightOrderExistScenarioTestDataForMakeRuleMeet() {
        return Arrays.asList(new Object[][] {
                {List.of(1, 2, 3, 4), PageOrderingRule.of(1, 2)},
        }).iterator();
    }
}