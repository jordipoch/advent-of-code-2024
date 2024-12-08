package aoc2024.main.runner;

import aoc2024.controller.Day1Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day1 extends BaseRunner {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String... args) {
        createInjector();

        runPart1();
    }

    public static int runPart1() {
        var controller = injector.getInstance(Day1Controller.class);

        int result = controller.getPart1Result();
        logger.info("The distance between lists is {}", result);
        return result;
    }
}
