package domain;


import exception.InvalidCarNameException;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        checkValidCarName(carName);
        this.carName = carName;
        this.position = 0;
    }

    private void checkValidCarName(String carName) {
        if (checkNameLength(carName) || checkAlphabetic(carName)) {
            throw new InvalidCarNameException();
        }
    }

    private boolean checkNameLength(String carName) {
        return carName.length() < 1 || carName.length() > 5;
    }

    private boolean checkAlphabetic(String carName) {
        return !carName.matches("^[a-zA-Z0-9]*$");
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
