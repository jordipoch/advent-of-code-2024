package aoc2024.model.day7;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EquationSetCalibrationFactoryTest {

    private EquationSetCalibrationFactory factory;

    @Test
    public void testCreate() {
        var equationFactory = new EquationFactory();
        var factory = new EquationSetCalibrationFactory(equationFactory);

        var equationSetCalibration = factory.create(List.of(
                "190: 10 19",
                "3267: 81 40 27",
                "83: 17 5"
        ));

        var expectedResult = new EquationSetCalibrator(List.of(
                equationFactory.create("190: 10 19"),
                equationFactory.create("3267: 81 40 27"),
                equationFactory.create("83: 17 5")
        ));

        assertThat(equationSetCalibration).isEqualTo(expectedResult);
    }
}