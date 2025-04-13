package aoc2024.model.day3;

import aoc2024.model.day3.instruction.Do;
import aoc2024.model.day3.instruction.Dont;
import aoc2024.model.day3.instruction.Multiply;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InstructionsExtractorTest {

    private InstructionsExtractor extractor;

    @BeforeMethod
    public void setUp() {
        extractor = new InstructionsExtractor();
    }

    @Test
    public void WhenAllInstructionAreMulAndAreCorrectShouldReturnAllInstructions() {

        String memoryData = "*mul(4,5){...mul(7,8){mul(122,45)mul(234,88)";

        Assertions.assertThat(extractor.extractInstructions(memoryData)).containsExactly(
                Multiply.of(4,5),
                Multiply.of(7,8),
                Multiply.of(122,45),
                Multiply.of(234,88)
        );
    }

    @Test
    public void WhenDifferentInstructionsAndAllCorrectShouldReturnAllInstructions() {

        String memoryData = "*mul(4,5){...mul(7,8).do(){mul(122,45)mul(234,88) don't()";

        Assertions.assertThat(extractor.extractInstructions(memoryData)).containsExactly(
                Multiply.of(4,5),
                Multiply.of(7,8),
                Do.getInstance(),
                Multiply.of(122,45),
                Multiply.of(234,88),
                Dont.getInstance()
        );
    }

    @Test
    public void WhenThereAreIncorrectOrIncompleteInstructionsShouldReturnOnlyCorrectOnes() {
        String memoryData = "*mul(4,5)don't(){...mull(7,8){'mul(78,34...mul(122,45),mul(1,2,3)..do().mul(234,8888)"
                + "do(3,4)_dont()#don't(50,55)";

        Assertions.assertThat(extractor.extractInstructions(memoryData)).containsExactly(
                Multiply.of(4,5),
                Dont.getInstance(),
                Multiply.of(122,45),
                Do.getInstance()
        );
    }
}