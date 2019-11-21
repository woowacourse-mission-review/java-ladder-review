package games.racinggame.domain;

import games.racinggame.exception.InvalidCarNameException;
import games.racinggame.view.InputView;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String carNames) {
        try {
            List<String> parsedCarNames = parse(carNames);
            checkValidCarNames(parsedCarNames);

            cars = parsedCarNames.stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
        } catch (InvalidCarNameException e) {
            System.out.println(e.getMessage());
            this.cars = null;
        }
    }

    private void checkValidCarNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() != carNames.size()) {
            throw new InvalidCarNameException();
        }
    }

    private List<String> parse(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(InputView.DELIMITER)));
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
        for (int index = 0, max = cars.size(); index < max; index++) {
            cars.get(index).move(instructions.get(index));
        }
    }

    public CarStatusSnapShot makeSnapShotsOfCars() {
        List<String> carNames = new ArrayList<>();
        List<Integer> carPositions = new ArrayList<>();

        for (Car car : cars) {
            carNames.add(car.getCarName());
            carPositions.add(car.getPosition());
        }

        return new CarStatusSnapShot(carNames, carPositions);
    }

    public List<String> getWinners() {
        Car winner = Collections.max(cars);
        return cars.stream()
                .filter(car -> car.isWinner(winner.getPosition()))
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
    }
}
