package games.racinggame.domain;

import games.racinggame.exception.InvalidCarNameException;
import games.racinggame.exception.MethodNotAllowedException;
import games.racinggame.input.RacingGameInputAsker;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private Optional<List<Car>> cars;
    public Cars(String userInput) {
        try {
            List<String> carNames = parse(userInput);
            checkValidCarNames(carNames);
            List<Car> cars = carNames.stream()
                    .map(carName -> new Car(carName))
                    .collect(Collectors.toList());
            this.cars = Optional.of(cars);
        } catch (InvalidCarNameException e) {
            this.cars = Optional.empty();
        }

    }

    private void checkValidCarNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() != carNames.size()) {
            throw new InvalidCarNameException();
        }
    }

    private List<String> parse(String userInput) {
        String preParseCarNames = userInput.split(RacingGameInputAsker.DELIMITER)[RacingGameInputAsker.FIRST_INDEX];
        return new ArrayList<>(Arrays.asList(preParseCarNames.split(",")));
    }

    public int size() {
        if (cars.isPresent()) {
            return cars.get().size();
        }
        throw new MethodNotAllowedException();
    }

    public Car getCarAt(int index) {
        if (cars.isPresent()) {
            return cars.get().get(index);
        }
        throw new MethodNotAllowedException();
    }

    public boolean isNotSucessfullyMade() {
        return !cars.isPresent();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars.get());
    }

    public void movePosition(List<Integer> instructions) {
        List<Car> cars = this.cars.get();
        for (int index = 0, max = cars.size(); index < max; index++ ) {
            cars.get(index).move(instructions.get(index));
        }
    }

    public CarStatusSnapShot makeSnapShotsOfCars() {
        List<String> carNames = new ArrayList<>();
        List<Integer> carPositions = new ArrayList();

        List<Car> cars = this.cars.get();
        for (Car car : cars) {
            carNames.add(car.getCarName());
            carPositions.add(car.getPosition());
        }

        return new CarStatusSnapShot(carNames, carPositions);
    }
}
