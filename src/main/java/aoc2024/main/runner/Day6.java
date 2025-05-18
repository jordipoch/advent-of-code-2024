package aoc2024.main.runner;

import aoc2024.controller.Day6Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day6 extends BaseRunner {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String... args) {
        createInjector();

        run();
    }

    public static void run() {
        runPart1();
    }

    public static long runPart1() {
        var controller = injector.getInstance(Day6Controller.class);

        long result = controller.getPart1Result();
        logger.info("Number of distinct positions visited by the guard: {}", result);
        return result;
    }
}
