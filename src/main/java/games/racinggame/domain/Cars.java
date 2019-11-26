package games.racinggame.domain;

import games.racinggame.exception.InvalidCarNameException;
import games.utility.BaseGameValidityChecker;
import games.utility.CommaParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String carNames) {
        try {
            List<String> parsedCarNames = CommaParser.parse(carNames);
            BaseGameValidityChecker.checkDuplicateCarNames(parsedCarNames);

            cars = parsedCarNames.stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
        } catch (InvalidCarNameException e) {
            System.out.println(e.getMessage());
            this.cars = null;
        }
    }

    public int size() {
        return cars.size();
    }

    public Car getCarAt(int index) {
        return cars.get(index);
    }

    public boolean isNotSuccessfullyMade() {
        return cars == null;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void movePosition(List<Integer> instructions) {
        int max = cars.size();
        for (int index = 0; index < max; index++) {
            cars.get(index).move(instructions.get(index));
        }
    }

    public CarStatusSnapShot makeSnapShotsOfCars() {
        List<String> carNames = new ArrayList<>();
        List<Integer> carPositions = new ArrayList<>();

        for (Car car : cars) {
            carNames.add(car.getName());
            carPositions.add(car.getPosition());
        }

        return new CarStatusSnapShot(carNames, carPositions);
    }

    public List<String> getWinners() {
        Car winner = Collections.max(cars);
        return cars.stream()
                .filter(car -> car.isWinner(winner.getPosition()))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
