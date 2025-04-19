package aoc2024.main.runner;

import aoc2024.controller.Day4Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Day4 extends BaseRunner {
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
        var controller = injector.getInstance(Day4Controller.class);

        long result = controller.getPart1Result();
        logger.info("Number of XMAS words found {}", result);
        return result;
    }

    public static long runPart2() {
        var controller = injector.getInstance(Day4Controller.class);

        long result = controller.getPart2Result();
        logger.info("Number of X-Shaped MAS words found {}", result);
        return result;
    }
}
