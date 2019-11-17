package domain;

import java.util.*;

public class CarStatusSnapShot {
    private List<String> carNames;
    private List<Integer> carPositions;

    public CarStatusSnapShot(List<String> carNames, List<Integer> carPositions) {
        this.carNames = carNames;
        this.carPositions = carPositions;
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    public List<Integer> getCarPositions() {
        return Collections.unmodifiableList(carPositions);
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        List<Integer> indexOfWinners = new ArrayList<>();
        int max = findMax(carPositions);
        for (int index = 0, length = carNames.size(); index < length; index++) {
            if (carPositions.get(index) == max) {
                winners.add(carNames.get(index));
            }
        }
        return winners;
    }

    private int findMax(List<Integer> carPositions) {
        int max = 0;
        for (Integer carPosition : carPositions) {
            if (carPosition > max) {
                max = carPosition;
            }
        }
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarStatusSnapShot that = (CarStatusSnapShot) o;
        return Objects.equals(carNames, that.carNames) &&
                Objects.equals(carPositions, that.carPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNames, carPositions);
    }
}
