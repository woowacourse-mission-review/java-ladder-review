package games.racinggame.domain;

import games.racinggame.domain.instructions.MovementInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingRounds {
    private static final int GAME_BOUNDARY = 0;
    private int racingRounds;

    public RacingRounds(String rawRacingRounds) {
        try {
            int racingRounds = Integer.parseInt(rawRacingRounds);
            checkValidRacingRounds(racingRounds);
            this.racingRounds = racingRounds;
        } catch (Exception e) {
            System.out.println("경기횟수는 0이상의 정수만 허용합니다 정수만 허용합니다!");
            this.racingRounds = GAME_BOUNDARY;
        }
    }

    private void checkValidRacingRounds(int racingRounds) {
        if (racingRounds <= GAME_BOUNDARY) {
            throw new IllegalArgumentException();
        }
    }

    public int getRounds() {
        return racingRounds;
    }

    public boolean isNotSuccessfullyMade() {
        return racingRounds == GAME_BOUNDARY;
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
