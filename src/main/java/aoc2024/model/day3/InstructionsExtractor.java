package aoc2024.model.day3;

import aoc2024.model.day3.instruction.Do;
import aoc2024.model.day3.instruction.Dont;
import aoc2024.model.day3.instruction.Instruction;
import aoc2024.model.day3.instruction.Multiply;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Singleton
public class InstructionsExtractor {
    private static final Pattern INSTRUCTION_PATTERN = Pattern.compile("(mul|do|don't)\\([\\d,]*\\)");
    private static final Pattern MUL_PATTERN = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
    private static final String MUL_INSTRUCTION_CODE = "mul";
    private static final String DO_INSTRUCTION = "do()";
    private static final String DONT_INSTRUCTION = "don't()";

    public List<Instruction> extractInstructions(String data) {
        var instructionMatcher = INSTRUCTION_PATTERN.matcher(data);

        List<Instruction> instructions = new ArrayList<>();

        while (instructionMatcher.find()) {
            var optionalInstruction = handleInstruction(instructionMatcher);
            optionalInstruction.ifPresent(instructions::add);
        }

        return instructions;
    }

    private Optional<Instruction> handleInstruction(Matcher instructionMatcher) {
        var instruction = instructionMatcher.group(0);
        var instructionCode = instructionMatcher.group(1);

        if (MUL_INSTRUCTION_CODE.equals(instructionCode)) {
           return handleMulInstruction(instruction);
        } else if (DO_INSTRUCTION.equals(instruction)) {
            return Optional.of(Do.getInstance());
        } else if (DONT_INSTRUCTION.equals(instruction)) {
            return Optional.of(Dont.getInstance());
        }

        return Optional.empty();
    }

    private Optional<Instruction> handleMulInstruction(String instruction) {
        var mulInstructionMatcher = MUL_PATTERN.matcher(instruction);
        if (mulInstructionMatcher.find()) {
            int value1 = Integer.parseInt(mulInstructionMatcher.group(1));
            int value2 = Integer.parseInt(mulInstructionMatcher.group(2));
            return Optional.of(Multiply.of(value1, value2));
        } else {
            return Optional.empty();
        }
    }
}
