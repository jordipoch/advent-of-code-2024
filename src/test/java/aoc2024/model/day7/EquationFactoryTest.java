package aoc2024.model.day7;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EquationFactoryTest {

    @Test
    public void testCreate() {
        var factory = new EquationFactory();
        var equation = factory.create("292: 11 6 16 20");
        var expectedEquation = Equation.builder()
                        .result(292)
                        .testValues(List.of(11, 6, 16, 20))
                        .build();

        assertThat(equation).isEqualTo(expectedEquation);
    }
}