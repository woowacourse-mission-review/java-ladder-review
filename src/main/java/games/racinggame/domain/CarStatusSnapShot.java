package games.racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
