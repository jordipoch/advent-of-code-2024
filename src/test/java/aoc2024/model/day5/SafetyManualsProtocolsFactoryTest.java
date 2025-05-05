package aoc2024.model.day5;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class SafetyManualsProtocolsFactoryTest {

    @Test
    public void testCreate() {
        var factory = new SafetyManualsProtocolsFactory();
        List<String> data = List.of(
                        "47|53",
                        "97|13",
                        "",
                        "75,47,61,53,29",
                        "97,61,53,29,13");

        var created = factory.create(data);
        var expected = SafetyManualsProtocols.builder()
                        .rules(List.of(
                                PageOrderingRule.of(47, 53),
                                PageOrderingRule.of(97, 13)))
                        .manualUpdates(List.of(
                                ManualUpdate.of(List.of(75,47,61,53,29)),
                                ManualUpdate.of(List.of(97,61,53,29,13))))
                        .build();
        Assertions.assertThat(created).isEqualTo(expected);
    }
}