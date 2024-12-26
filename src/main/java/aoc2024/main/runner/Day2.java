package aoc2024.main.runner;

import aoc2024.controller.Day2Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day2 extends BaseRunner {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String... args) {
        createInjector();

        runPart1();
        runPart2();
    }

    public static int runPart1() {
        var controller = injector.getInstance(Day2Controller.class);

        int result = controller.getPart1Result();
        logger.info("There are {} safe reports", result);
        return result;
    }

    public static int runPart2() {
        var controller = injector.getInstance(Day2Controller.class);

        int result = controller.getPart2Result();
        logger.info("There are {} safe reports tolerating one bad level", result);
        return result;
    }
}
