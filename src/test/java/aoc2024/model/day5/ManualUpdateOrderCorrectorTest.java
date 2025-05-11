package aoc2024.model.day5;

import aoc2024.model.day5.exception.ManualUpdatePageOrderingException;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualUpdateOrderCorrectorTest {

    @Test
    public void testWhenNoAdditionalReordersAreNeeded() throws ManualUpdatePageOrderingException {
        var manualUpdate = ManualUpdate.of(List.of(1,2,3,4));
        var pageOrderingRules = List.of(
                PageOrderingRule.of(1,2),
                PageOrderingRule.of(4,2)
        );

        var manualUpdateOrderCorrector = new ManualUpdateOrderCorrector(manualUpdate, pageOrderingRules, 1);
        var correctlyOrderedManualUpdate = manualUpdateOrderCorrector.getCorrectlyOrderedManualUpdate();

        assertThat(correctlyOrderedManualUpdate.meetsAllRules(pageOrderingRules)).isTrue();
    }

    @Test
    public void testWhenOneAdditionalReorderIsNeeded() throws ManualUpdatePageOrderingException {
        var manualUpdate = ManualUpdate.of(List.of(1,2,3,4));
        var pageOrderingRules = List.of(
                PageOrderingRule.of(3,4),
                PageOrderingRule.of(4,2)
        );

        var manualUpdateOrderCorrector = new ManualUpdateOrderCorrector(manualUpdate, pageOrderingRules, 2);
        var correctlyOrderedManualUpdate = manualUpdateOrderCorrector.getCorrectlyOrderedManualUpdate();

        assertThat(correctlyOrderedManualUpdate.meetsAllRules(pageOrderingRules)).isTrue();
    }

    @Test
    public void testWhenTwoAdditionalReordersAreNeeded() throws ManualUpdatePageOrderingException {
        var manualUpdate = ManualUpdate.of(List.of(1, 2, 9, 4, 5, 6, 7, 8, 3, 10));
        var pageOrderingRules = List.of(
                PageOrderingRule.of(3,9),
                PageOrderingRule.of(8,3),
                PageOrderingRule.of(7,8)
        );

        var manualUpdateOrderCorrector = new ManualUpdateOrderCorrector(manualUpdate, pageOrderingRules, 3);
        var correctlyOrderedManualUpdate = manualUpdateOrderCorrector.getCorrectlyOrderedManualUpdate();

        assertThat(correctlyOrderedManualUpdate.meetsAllRules(pageOrderingRules)).isTrue();
    }

    @Test(expectedExceptions = ManualUpdatePageOrderingException.class)
    public void testWhenDoesntMeetAllRulesAfterMaxReorderingAttempts() throws ManualUpdatePageOrderingException {
        var manualUpdate = ManualUpdate.of(List.of(1, 2, 9, 4, 5, 6, 7, 8, 3, 10));
        var pageOrderingRules = List.of(
                PageOrderingRule.of(3,9),
                PageOrderingRule.of(8,3),
                PageOrderingRule.of(7,8)
        );

        var manualUpdateOrderCorrector = new ManualUpdateOrderCorrector(manualUpdate, pageOrderingRules, 2);
        var correctlyOrderedManualUpdate = manualUpdateOrderCorrector.getCorrectlyOrderedManualUpdate();

        assertThat(correctlyOrderedManualUpdate.meetsAllRules(pageOrderingRules)).isTrue();
    }

    @Test
    public void testWhenSwappingElementsAlwaysCauseOtherRulesToBreak() throws ManualUpdatePageOrderingException {
        var manualUpdate = ManualUpdate.of(List.of(74, 52, 55));
        var pageOrderingRules = List.of(
                PageOrderingRule.of(55,74),
                PageOrderingRule.of(52,55),
                PageOrderingRule.of(52,74)
        );

        var manualUpdateOrderCorrector = new ManualUpdateOrderCorrector(manualUpdate, pageOrderingRules, 2);
        var correctlyOrderedManualUpdate = manualUpdateOrderCorrector.getCorrectlyOrderedManualUpdate();

        assertThat(correctlyOrderedManualUpdate.meetsAllRules(pageOrderingRules)).isTrue();
    }

    @Test
    public void testWhenSomeRulesAreAutomaticallyMetAfterProcessingPreviousRules() throws ManualUpdatePageOrderingException {
        var manualUpdate = ManualUpdate.of(List.of(74, 55, 52));
        var pageOrderingRules = List.of(
                PageOrderingRule.of(52,74),
                PageOrderingRule.of(52,55),
                PageOrderingRule.of(55,74)
        );

        var manualUpdateOrderCorrector = new ManualUpdateOrderCorrector(manualUpdate, pageOrderingRules, 2);
        var correctlyOrderedManualUpdate = manualUpdateOrderCorrector.getCorrectlyOrderedManualUpdate();

        assertThat(correctlyOrderedManualUpdate.meetsAllRules(pageOrderingRules)).isTrue();
    }
}