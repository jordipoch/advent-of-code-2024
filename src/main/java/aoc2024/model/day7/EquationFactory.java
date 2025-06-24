package aoc2024.model.day7;

import aoc2024.library.string.StringUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class EquationFactory {
    public Equation create(String strRepresentation) {
        var equationData = createEquationData(strRepresentation);

        return Equation.builder()
                .result(equationData.getResult())
                .testValues(equationData.getTestValues())
                .build();
    }

    public Equation createWithConcat(String strRepresentation) {
        var equationData = createEquationData(strRepresentation);

        return EquationWithConcat.builder()
                .result(equationData.getResult())
                .testValues(equationData.getTestValues())
                .build();
    }

    private EquationData createEquationData(String strRepresentation) {
        List<String> equationParts = StringUtils.split(strRepresentation, ": ");
        long result = Long.parseLong(equationParts.get(0));
        List<Integer> values = StringUtils.split(equationParts.get(1), " ").stream()
                .map(Integer::parseInt)
                .toList();

        return new EquationData(result, values);
    }

    @RequiredArgsConstructor
    @Getter
    private static class EquationData {
        private final long result;
        protected final List<Integer> testValues;
    }
}
