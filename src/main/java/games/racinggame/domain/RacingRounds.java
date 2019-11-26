package games.racinggame.domain;

import games.racinggame.domain.instructions.MovementInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static games.utility.BaseGameValidityChecker.checkValidQuantity;

public class RacingRounds {
    private static int WRONG_ROUNDS = 0;
    private int racingRounds;

    public RacingRounds(String rawRacingRounds) {
        try {
            int racingRounds = Integer.parseInt(rawRacingRounds);
            checkValidQuantity(racingRounds);
            this.racingRounds = racingRounds;
        } catch (Exception e) {
            System.out.println("경기횟수는 0이상의 정수만 허용합니다!");
            this.racingRounds = WRONG_ROUNDS;
        }
    }

    public int getRounds() {
        return racingRounds;
    }

    public boolean isNotSuccessfullyMade() {
        return racingRounds == WRONG_ROUNDS;
    }

    public GameResult doRounds(Cars cars, MovementInstruction movementInstruction) {
        int currentRound = 0;
        List<CarStatusSnapShot> snapShots = new ArrayList<>();

        while (currentRound < racingRounds) {
            cars.movePosition(generateInstructions(cars, movementInstruction));
            snapShots.add(cars.makeSnapShotsOfCars());
            currentRound++;
        }
        return new GameResult(snapShots, cars.getWinners());
    }

    private List<Integer> generateInstructions(Cars cars, MovementInstruction movementInstruction) {
        return cars.getCars().stream()
                .map(car -> movementInstruction.provideInstructionForCars())
                .collect(Collectors.toList());
    }
}
