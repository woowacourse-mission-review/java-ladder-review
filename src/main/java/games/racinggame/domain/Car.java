package games.racinggame.domain;


import games.racinggame.exception.InvalidCarNameException;

public class Car implements Comparable<Car> {
    private static final int INITIAL_POSITION = 0;
    private static final int MOVEMENT_BOUNDARY = 4;
    private static final int CARNAME_LOWERBOUNDARY = 1;
    private static final int CARNAME_UPPERBOUNDARY = 5;
    private static final String ALLOWED_PATTERNS = "^[a-zA-Z0-9]*$";

    private final String carName;
    private int position;

    public Car(String carName, int position) {
        checkValidCarName(carName);
        this.carName = carName;
        this.position = position;

    }

    public Car(String carName) {
        this(carName, INITIAL_POSITION);
    }

    private void checkValidCarName(String carName) {
        if (checkNameLength(carName) || checkAlphabetic(carName)) {
            throw new InvalidCarNameException();
        }
    }

    private boolean checkNameLength(String carName) {
        return carName.length() < CARNAME_LOWERBOUNDARY || carName.length() > CARNAME_UPPERBOUNDARY;
    }

    private boolean checkAlphabetic(String carName) {
        return !carName.matches(ALLOWED_PATTERNS);
    }

    public void move(int instruction) {
        if (instruction >= MOVEMENT_BOUNDARY) {
            this.position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int position) {
        return position == this.position;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(position, o.position);
    }
}
