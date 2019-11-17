package game;

import domain.CarStatusSnapShot;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameResult {
    private List<CarStatusSnapShot> snapShots;

    public GameResult(List<CarStatusSnapShot> snapShots) {
        this.snapShots = snapShots;
    }

    public List<CarStatusSnapShot> getSnapShots() {
        return Collections.unmodifiableList(snapShots);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(snapShots, that.snapShots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(snapShots);
    }
}
