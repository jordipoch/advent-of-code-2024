package aoc2024.main.runner;

import aoc2024.controller.Day1Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day1 extends BaseRunner {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String... args) {
        createInjector();

        run();
    }

    public static void run() {
        runPart1();
        runPart2();
    }

    public static int runPart1() {
        var controller = injector.getInstance(Day1Controller.class);

        int result = controller.getPart1Result();
        logger.info("The distance between lists is {}", result);
        return result;
    }

    public static long runPart2() {
        var controller = injector.getInstance(Day1Controller.class);

        long result = controller.getPart2Result();
        logger.info("The similarity score between lists is {}", result);
        return result;
    }
}
