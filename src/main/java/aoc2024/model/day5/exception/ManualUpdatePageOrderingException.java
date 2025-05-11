package aoc2024.model.day5.exception;

import aoc2024.model.day5.ManualUpdate;

public class ManualUpdatePageOrderingException extends RuntimeException {
    public ManualUpdatePageOrderingException(ManualUpdate manualUpdate, int attempts) {
        super(String.format("Unable to rearrange manual update (%s) after %d attempts", manualUpdate, attempts));
    }
}
