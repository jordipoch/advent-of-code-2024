package aoc2024.main.runner;

import aoc2024.controller.Day7Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day7 extends BaseRunner {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String... args) {
        createInjector();

        run();
    }

    public static void run() {
        runPart1();
        runPart2();
    }

    public static long runPart1() {
        var controller = injector.getInstance(Day7Controller.class);

        long result = controller.getPart1Result();
        logger.info("The calibration result is: {}", result);
        return result;
    }

    public static long runPart2() {
        var controller = injector.getInstance(Day7Controller.class);

        long result = controller.getPart2Result();
        logger.info("The calibration result with concatenation operator is: {}", result);
        return result;
    }
}
