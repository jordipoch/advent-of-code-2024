package aoc2024.model.day3;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Singleton
public class InstructionsExtractor {
    private static final String PATTERN = "mul\\((\\d{1,3}),(\\d{1,3})\\)";

    public List<MultiplyInstruction> extractInstructions(String data) {
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(data);

        List<MultiplyInstruction> instructions = new ArrayList<>();

        while (m.find()) {
            int value1 = Integer.parseInt(m.group(1));
            int value2 = Integer.parseInt(m.group(2));
            instructions.add(MultiplyInstruction.of(value1, value2));
        }

        return instructions;
    }
}
