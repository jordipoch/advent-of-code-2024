package aoc2024.controller;

import aoc2024.input.InputFileDataLoaderFactory;
import aoc2024.main.config.InjectorModule;
import aoc2024.model.day6.ManufacturingLabFactory;
import aoc2024.model.day6.ManufacturingLabSimulatorFactory;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day6ControllerTest {
    private Day6Controller controller;

    @BeforeMethod
    public void setUp() {
        Injector injector = Guice.createInjector(new InjectorModule());

        var manufacturingLabFactory = new ManufacturingLabFactory();
        var manufacturingLabSimulatorFactory = injector.getInstance(ManufacturingLabSimulatorFactory.class);

        controller = new Day6Controller(new InputFileDataLoaderFactory(), manufacturingLabFactory, manufacturingLabSimulatorFactory);
    }

    @Test
    public void testGetPart1Result() {
        assertThat(controller.getPart1Result()).isEqualTo(41);
    }

    @Test
    public void testGetPart2Result() {
        assertThat(controller.getPart2Result()).isEqualTo(6);
    }
}