package aoc2024.model.day4;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CrosswordsTest {

    @Test
    public void whenCountNumberOfXMASShouldCountThemAll() {
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
}