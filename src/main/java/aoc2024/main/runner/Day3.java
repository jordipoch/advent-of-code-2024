package aoc2024.main.runner;

import aoc2024.controller.Day3Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day3 extends BaseRunner {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String... args) {
        createInjector();

        runPart1();
    }

    public static long runPart1() {
        var controller = injector.getInstance(Day3Controller.class);

        long result = controller.getPart1Result();
        logger.info("All multiply instructions results add up {}", result);
        return result;
    }
}
