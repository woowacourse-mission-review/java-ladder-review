package games.racinggame.domain;

import games.racinggame.domain.instructions.MovementInstruction;
import games.racinggame.input.RacingGameInputAsker;

import java.util.ArrayList;
import java.util.List;
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
        return !racingRounds.isPresent();
    }

    public GameResult doRounds(Cars cars, MovementInstruction movementInstruction) {
        int currentRound = 0;
        List<CarStatusSnapShot> snapShots = new ArrayList<>();

        while (currentRound != racingRounds.get()) {
            List<Integer> instructions = new ArrayList<>();
            for (Car car : cars.getCars()) {
                instructions.add(movementInstruction.provideInstructionForCars());
            }
            cars.movePosition(instructions);
            snapShots.add(cars.makeSnapShotsOfCars());
            currentRound++;
        }
        return new GameResult(snapShots);
    }
}
