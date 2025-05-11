package aoc2024.model.day5;

import aoc2024.model.day5.exception.ManualUpdatePageOrderingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ManualUpdateOrderCorrector {
    private static final int DEFAULT_REORDERING_ATTEMPTS = 10;

    private static final Logger logger = LogManager.getLogger();

    private final ManualUpdate manualUpdate;
    private final List<PageOrderingRule> rules;
    private final int reorderingAttempts;

    public static ManualUpdateOrderCorrector of(ManualUpdate manualUpdate, List<PageOrderingRule> rules) {
        return new ManualUpdateOrderCorrector(manualUpdate, rules);
    }

    public ManualUpdateOrderCorrector(ManualUpdate manualUpdate, List<PageOrderingRule> rules) {
        this(manualUpdate, rules, DEFAULT_REORDERING_ATTEMPTS);
    }

    public ManualUpdateOrderCorrector(ManualUpdate manualUpdate, List<PageOrderingRule> rules, int reorderingAttempts) {
        this.manualUpdate = manualUpdate;
        this.rules = rules;
        this.reorderingAttempts = reorderingAttempts;
    }

    public ManualUpdate getCorrectlyOrderedManualUpdate() throws ManualUpdatePageOrderingException {
        var reorderedManualUpdate = manualUpdate;
        int attempts = 0;

        while (!reorderedManualUpdate.meetsAllRules(rules) && attempts < reorderingAttempts) {
            var rulesNotMet = reorderedManualUpdate.getRulesNotMet(rules);
            reorderedManualUpdate = processRules(reorderedManualUpdate, rulesNotMet);
            attempts ++;
        }

        if (!reorderedManualUpdate.meetsAllRules(rules)) {
            writeDebugInfo(reorderedManualUpdate);
            throw new ManualUpdatePageOrderingException(manualUpdate, reorderingAttempts);
        }

        return reorderedManualUpdate;
    }

    private ManualUpdate processRules(ManualUpdate reorderedManualUpdate, List<PageOrderingRule> rulesNotMet) {
        for (var rule : rulesNotMet) {
            if (!reorderedManualUpdate.meetsRule(rule))
                reorderedManualUpdate = reorderedManualUpdate.makeRuleMeet(rule);
        }
        return reorderedManualUpdate;
    }

    private void writeDebugInfo(ManualUpdate reorderedManualUpdate) {
        var originalRulesNotMet = manualUpdate.getRulesNotMet(rules);
        var rulesNotMetAfterReordering = reorderedManualUpdate.getRulesNotMet(rules);

        logger.debug("Original manual update ({}) was not meeting rules ({})", manualUpdate, originalRulesNotMet);
        logger.debug("Reordered manual update ({}) is not meeting rules ({})", reorderedManualUpdate, rulesNotMetAfterReordering);
    }
}
