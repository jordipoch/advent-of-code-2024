package aoc2024.model.day6;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ManufacturingLabFactory {
    public ManufacturingLab create(List<String> inputMap) {
        
        var internalMap = new Character[inputMap.size()][inputMap.get(0).length()];

        for (int y = 0; y < inputMap.size(); y++) {
            for (int x = 0; x < inputMap.get(0).length(); x++) {
                char c = inputMap.get(y).charAt(x);
                internalMap[y][x] = c;
            }
        }

        return new ManufacturingLab(internalMap);
    }
}
