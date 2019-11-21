package games.racinggame.view;

import games.racinggame.domain.CarStatusSnapShot;
import games.racinggame.domain.GameResult;

import java.util.List;

public class OutputView {

    public void view(GameResult gameResult) {
        System.out.println("결과입니다");
        List<CarStatusSnapShot> snapShots = gameResult.getSnapShots();
        for (CarStatusSnapShot snapShot : snapShots) {
            printEach(snapShot);
        }
        System.out.println("우승자입니다");
        snapShots.get(snapShots.size() -1);

        printWinners(gameResult.findWinners());
    }

    private void printWinners(List<String> winners) {
        for (String winner : winners) {
            System.out.println(winner);
        }
    }

    private void printEach(CarStatusSnapShot snapShot) {
        List<String> carNames = snapShot.getCarNames();
        List<Integer> carPositions = snapShot.getCarPositions();

        for (int index = 0, max = carNames.size(); index < max; index++) {
            System.out.print(carNames.get(index));
            System.out.print(":");
            int currentPosition = carPositions.get(index);
            for (int j = 0; j < currentPosition; j++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
}
