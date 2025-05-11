package aoc2024.model.day5;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SafetyManualsProtocolsTest {
    private static SafetyManualsProtocolsFactory factory;

    @BeforeClass
    public void beforeClass() {
        factory = new SafetyManualsProtocolsFactory();
    }

    @Test(dataProvider = "getMiddlePageSumOfCorrectlyOrderedUpdatesTestData")
    public void whenSomeManualUpdatesMeetsAllSafetyRulesShouldReturnSumOfMiddleNumbers(List<String> data, int expectedResult) {
        var safetyManualProtocols = factory.create(data);

        assertThat(safetyManualProtocols.getMiddlePageSumOfCorrectlyOrderedUpdates()).isEqualTo(expectedResult);
    }

    @DataProvider
    private Iterator<Object[]> getMiddlePageSumOfCorrectlyOrderedUpdatesTestData() {
        return Arrays.asList(new Object[][] {
                {List.of( // Single manual update meets all rules
                        "75|29",
                        "12|28",
                        "",
                        "75,29,13"),
                        29},
                {List.of( // All manual updates meet all rules
                        "75|29",
                        "29|13",
                        "12|77",
                        "77|67",
                        "",
                        "75,29,13",
                        "12,77,67"),
                        29+77},
                {List.of( // Some manual updates not meeting all rules
                        "75|29",
                        "29|13",
                        "12|77",
                        "77|67",
                        "38|24",
                        "13|56",
                        "",
                        "75,29,13",
                        "12,77,67",
                        "56,38,13,8,24"), // This violates the 13|56 rule
                        29+77},
                {List.of( // No manuals meet all safety rules
                        "75|29",
                        "13|29",
                        "",
                        "75,29,13"),
                        0}
        }).iterator();
    }

    @Test(dataProvider = "getMiddleSumOfIncorrectlyOrderedUpdatesAfterCorrectingThemTestData")
    public void testGetMiddleSumOfIncorrectlyOrderedUpdatesAfterCorrectingThem(List<String> data, int expectedResult) {
        var safetyManualProtocols = factory.create(data);

        assertThat(safetyManualProtocols.getMiddlePageSumOfIncorrectlyOrderedUpdatesAfterCorrectingThem()).isEqualTo(expectedResult);
    }

    @DataProvider
    private Iterator<Object[]> getMiddleSumOfIncorrectlyOrderedUpdatesAfterCorrectingThemTestData() {
        return Arrays.asList(new Object[][] {
                {List.of( // Only one manual not meeting the rules
                        "29|75",
                        "12|28",
                        "",
                        "75,29,13"),
                        75},
                {List.of( // Two manuals not meeting the rules
                        "29|75",
                        "12|28",
                        "72|12",
                        "",
                        "75,29,13",
                        "28,12,13",
                        "29,75,12"),
                        75+28},
        }).iterator();
    }
}