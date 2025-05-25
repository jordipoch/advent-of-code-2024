package aoc2024.model.day6;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ManufacturingLabFactory {
    public ManufacturingLab create(List<String> inputMap) {

        var internalMap = createInternalMap(inputMap);
        var guardPosition = getGuardPosition(internalMap);
        internalMap[guardPosition.y()][guardPosition.x()] = '.';

        return new ManufacturingLab(internalMap, guardPosition);
    }

    public ManufacturingLab createWithExtraObstacle(List<String> inputMap, Position extraObstacle) {

        var internalMap = createInternalMap(inputMap);
        var guardPosition = getGuardPosition(internalMap);

        internalMap[guardPosition.y()][guardPosition.x()] = '.';
        internalMap[extraObstacle.y()][extraObstacle.x()] = 'O';

        return new ManufacturingLab(internalMap, guardPosition);
    }

    public Character[][] createInternalMap(List<String> inputMap) {
        var internalMap = new Character[inputMap.size()][inputMap.get(0).length()];

        for (int y = 0; y < inputMap.size(); y++) {
            for (int x = 0; x < inputMap.get(0).length(); x++) {
                char c = inputMap.get(y).charAt(x);
                internalMap[y][x] = c;

            }
        }

        return internalMap;
    }

    public Position getGuardPosition(Character[][] internalMap) {
        for (int y = 0; y < internalMap.length; y++) {
            for (int x = 0; x < internalMap[y].length; x++) {
                if(internalMap[y][x] == '^') {
                    return Position.of(x, y);
                }
            }
        }

        throw new IllegalArgumentException("No guard position found in map");
    }
}
