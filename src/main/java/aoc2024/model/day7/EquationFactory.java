package aoc2024.model.day7;

import aoc2024.library.string.StringUtils;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class EquationFactory {
    public Equation create(String strRepresentation) {
        List<String> equationParts = StringUtils.split(strRepresentation, ": ");
        long result = Long.parseLong(equationParts.get(0));
        List<Integer> values = StringUtils.split(equationParts.get(1), " ").stream()
                .map(Integer::parseInt)
                .toList();

        return Equation.builder()
                .result(result)
                .testValues(values)
                .build();
    }
}
