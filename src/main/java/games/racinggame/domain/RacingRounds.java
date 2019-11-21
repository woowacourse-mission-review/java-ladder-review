package games.racinggame.domain;

import games.racinggame.domain.instructions.MovementInstruction;

import java.util.ArrayList;
import java.util.List;

public class RacingRounds {
    private int racingRounds;

    public RacingRounds(String rawRacingRounds) {
        try {
            int racingRounds = Integer.parseInt(rawRacingRounds);
            checkValidRacingRounds(racingRounds);
            this.racingRounds =racingRounds;
        } catch(Exception e) {
            System.out.println("경기횟수는 0이상의 정수만 허용합니다 정수만 허용합니다!");
            this.racingRounds = 0;
        }
    }

    private void checkValidRacingRounds(int racingRounds) {
        if (racingRounds <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getRounds() {
        return racingRounds;
    }

    public boolean isNotSuccessfullyMade() {
        return racingRounds == 0;
    }

    public GameResult doRounds(Cars cars, MovementInstruction movementInstruction) {
        int currentRound = 0;
        List<CarStatusSnapShot> snapShots = new ArrayList<>();

        while (currentRound <= racingRounds) {
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
