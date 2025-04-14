package aoc2024.main.runner;

import aoc2024.controller.Day4Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day4 extends BaseRunner {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String... args) {
        createInjector();

        runPart1();
    }

    public static long runPart1() {
        var controller = injector.getInstance(Day4Controller.class);

        long result = controller.getPart1Result();
        logger.info("Number of XMAS words found {}", result);
        return result;
    }
}
