package aoc2024.model.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CrosswordsTest {

    @Test
    public void testCountNumberOfXMAS() {
        var data = List.of(
                "....XXMAS.",
                ".SAMXMS...",
                "...S..A...",
                "..A.A.MS.X",
                "XMASAMX.MM",
                "X.....XA.A",
                "S.S.S.S.SS",
                ".A.A.A.A.A",
                "..M.M.M.MM",
                ".X.X.XMASX"
                );

        var crosswords = Crosswords.create()
            .data(data)
            .build();

        assertThat(crosswords.countNumberOfXMAS()).isEqualTo(18);
    }

    @Test(dataProvider = "XShapedMAS")
    public void testCountNumberOfXShapedMAS(List<String> data, int expectedResult) {
        var crosswords = Crosswords.create()
                .data(data)
                .build();

        assertThat(crosswords.countNumberOfXShapedMAS()).isEqualTo(expectedResult);
    }

    @DataProvider(name = "XShapedMAS")
    private Iterator<Object[]> getXShapedMAS() {
        return Arrays.asList(new Object[][] {
                { List.of(
                        "M.S",
                        ".A.",
                        "M.S"
                ), 1},
                { List.of(
                        "S.M",
                        ".A.",
                        "S.M"
                ), 1},
                { List.of(
                        "...",
                        "S.M",
                        ".A.",
                        "S.M"
                ), 1},
                { List.of(
                        "....",
                        "SMMS",
                        ".AA.",
                        "SMMS"
                ), 2},
                { List.of(
                        "A.M.SA",
                        "SMMAS.",
                        "SAM.SA",
                        "SAMSMS",
                        "SAMSAS",
                        "S.MMAM"

                ), 5}
        }).listIterator();
    }
}