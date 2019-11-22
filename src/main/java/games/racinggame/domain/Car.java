package games.racinggame.domain;
import games.racinggame.exception.InvalidCarNameException;
import games.utility.BaseGameValidityChecker;

public class Car implements Comparable<Car> {
    private static final int INITIAL_POSITION = 0;
    private static final int MOVEMENT_BOUNDARY = 4;

    private String name;
    private int position;

    public Car(String name, int position) {
        if (BaseGameValidityChecker.isNotValid(name)) {
            throw new InvalidCarNameException();
        }
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public void move(int instruction) {
        if (instruction >= MOVEMENT_BOUNDARY) {
            this.position++;
        }
    }

    public boolean isWinner(int position) {
        return position == this.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(position, o.position);
    }
}
