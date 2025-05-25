package aoc2024.model.day6;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ManufacturingLabSimulator {
    private static final Logger logger = LogManager.getLogger();

    private final List<String> inputMap;
    private final ManufacturingLabFactory factory;

    @Inject
    public ManufacturingLabSimulator(@Assisted List<String> inputMap, ManufacturingLabFactory manufacturingLabFactory) {
        this.inputMap = inputMap;
        this.factory = manufacturingLabFactory;
    }

    /*public static ManufacturingLabSimulator of(List<String> inputMap) {
        return new ManufacturingLabSimulator(inputMap);
    }*/

    public int countNumberOfPositionsWhereTheObstructionCausesALoop() {
        var obstaclesWithLoops = factory.create(inputMap)
                .simulateGuardWalking()
                .getPositionsVisited()
                .stream()
                .skip(1)
                .map(p -> factory.createWithExtraObstacle(inputMap, p))
                .map(ManufacturingLab::simulateGuardWalking)
                .filter(ManufacturingLab::isLoopDetected)
                .toList();

        int numLoops = obstaclesWithLoops.size();
        if (numLoops > 0) {
            logger.debug("Found {} positions where the obstacle would cause a loop", numLoops);
            for (var lab : obstaclesWithLoops) {
                logger.debug("Loop detected in simulation: {}{}", System.lineSeparator(), lab);
            }
        }


        return numLoops;
    }
}
