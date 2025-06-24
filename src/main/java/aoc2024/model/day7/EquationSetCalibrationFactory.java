package aoc2024.model.day7;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class EquationSetCalibrationFactory {

    private final EquationFactory equationFactory;

    @Inject
    public EquationSetCalibrationFactory(EquationFactory equationFactory) {
        this.equationFactory = equationFactory;
    }

    public EquationSetCalibrator create(List<String> equationsData) {
        return new EquationSetCalibrator(equationsData.stream()
                .map(equationFactory::create)
                .toList());
    }
}
