package games.racinggame.view;

import games.racinggame.domain.CarStatusSnapShot;
import games.racinggame.domain.GameResult;

import java.util.List;

public class OutputView {

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static class LazyHolder{
        public static OutputView INSTANCE = new OutputView();
    }

    public void printGameResult(GameResult gameResult) {
        printEachRound(gameResult.getSnapShots());
        printWinners(gameResult.findWinners());
    }

    private void printEachRound(List<CarStatusSnapShot> snapShots) {
        System.out.println("결과입니다!");
        for (CarStatusSnapShot snapShot : snapShots) {
            printEach(snapShot);
        }
    }

    private void printWinners(List<String> winners) {
        System.out.println("우승자들입니디다! 축하해 주십시오!");
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
