package domain;

import input.RacingGameInputAsker;

import java.util.Optional;

public class RacingRounds {
    private Optional<Integer> racingRounds;

    public RacingRounds(String userInput) {
        try {
            String racingRounds = parse(userInput);
            int rounds = Integer.parseInt(racingRounds);
            this.racingRounds = Optional.of(rounds);
        } catch(NumberFormatException | IndexOutOfBoundsException e) {
            this.racingRounds = Optional.empty();
        }
    }

    private String parse(String userInput) {
        return userInput.split(RacingGameInputAsker.DELIMITER)[RacingGameInputAsker.LAST_INDEX];
    }

    public int getRounds() {
        return racingRounds.get();
    }

    public boolean isNotSuccesfullyMade() {
        return ! racingRounds.isPresent();
    }
}
