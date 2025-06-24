package aoc2024.model.day7;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class EquationWithConcatTest {

    private EquationFactory factory;

    @BeforeMethod
    public void setUp() {
        factory = new EquationFactory();
    }

    @Test(dataProvider = "getSolvableEquations")
    public void whenEquationWithTwoTestValuesCanBeSolvedShouldReturnTrue(String equationData) {
        var calibrationEquation = factory.createWithConcat(equationData);

        assertThat(calibrationEquation.canBeSolved()).isTrue();
    }

    @Test(dataProvider = "getUnsolvableEquations")
    public void whenEquationCannotBeSolvedShouldReturnFalse(String equationData) {
        var calibrationEquation = factory.createWithConcat(equationData);

        assertThat(calibrationEquation.canBeSolved()).isFalse();
    }

    @DataProvider
    private Iterator<Object[]> getSolvableEquations() {
        return Arrays.asList(new Object[][]{
                {"190: 10 19"},
                {"3267: 81 40 27"},
                {"292: 11 6 16 20"},
                {"156: 15 6"},
                {"7290: 6 8 6 15"},
                {"192: 17 8 14"}
        }).listIterator();
    }

    @DataProvider
    private Iterator<Object[]> getUnsolvableEquations() {
        return Arrays.asList(new Object[][]{
                {"83: 17 5"},
                {"161011: 16 10 13"},
                {"21037: 9 7 18 13"},
        }).listIterator();
    }
}