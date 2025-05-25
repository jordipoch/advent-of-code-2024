package aoc2024.model.day6;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CellTest {

    @Test(dataProvider = "Not visited by guard scenario")
    public void givenCellNotVisitedByGuardWhenGetContentShouldReturnExpectedContent(char cellChar) {
        var cell = Cell.of(cellChar);

        Assertions.assertThat(cell.getContent()).isEqualTo(cellChar);
    }

    @Test(dataProvider = "Visited by guard scenario")
    public void givenCellVisitedByGuardWhenGetContentShouldReturnCharacterRepresentation(List<GuardDirection> visitedDirections, char expectedContent) {
        var cell = Cell.of('.');
        visitedDirections.forEach(cell::markVisited);

        Assertions.assertThat(cell.getContent()).isEqualTo(expectedContent);
    }

    @DataProvider(name = "Not visited by guard scenario")
    protected Iterator<Object[]> getNotVisitedByGuardScenarioTestData() {
        return Arrays.asList(new Object[][] {
                {'.'},
                {'#'},
                {'O'}
        }).iterator();
    }

    @DataProvider(name = "Visited by guard scenario")
    protected Iterator<Object[]> getVisitedByGuardScenarioTestData() {
        return Arrays.asList(new Object[][] {
                { List.of(GuardDirection.UP), '|'},
                { List.of(GuardDirection.RIGHT), '-'},
                { List.of(GuardDirection.DOWN), '|'},
                { List.of(GuardDirection.LEFT), '-'},
                { List.of(GuardDirection.UP, GuardDirection.RIGHT), '+'},
                { List.of(GuardDirection.UP, GuardDirection.DOWN), '|'},
                { List.of(GuardDirection.RIGHT, GuardDirection.DOWN), '+'},
                { List.of(GuardDirection.DOWN, GuardDirection.LEFT), '+'},
                { List.of(GuardDirection.LEFT, GuardDirection.RIGHT), '-'},
        }).iterator();
    }
}