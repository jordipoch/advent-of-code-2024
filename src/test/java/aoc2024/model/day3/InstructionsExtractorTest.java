package aoc2024.model.day3;

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
    public void WhenAllInstructionsAreCompleteAndCorrectShouldReturnAllInstructions() {

        String memoryData = "*mul(4,5){...mul(7,8){mul(122,45)mul(234,88) ";

        Assertions.assertThat(extractor.extractInstructions(memoryData)).containsExactly(
                MultiplyInstruction.of(4,5),
                MultiplyInstruction.of(7,8),
                MultiplyInstruction.of(122,45),
                MultiplyInstruction.of(234,88)
        );
    }

    @Test
    public void WhenThereAreIncorrectOrIncompleteInstructionsShouldReturnOnlyCorrectOnes() {
        String memoryData = "*mul(4,5){...mull(7,8){'mul(78,34...mul(122,45),mul(1,2,3)...mul(234,8888)";

        Assertions.assertThat(extractor.extractInstructions(memoryData)).containsExactly(
                MultiplyInstruction.of(4,5),
                MultiplyInstruction.of(122,45)
        );
    }
}