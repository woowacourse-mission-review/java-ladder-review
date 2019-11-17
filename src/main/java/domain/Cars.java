package domain;

import exception.InvalidCarNameException;
import exception.MethodNotAllowedException;
import input.RacingGameInputAsker;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private Optional<Map<String, Car>> cars;
    public Cars(String userInput) {
        try {
            List<String> carNames = parse(userInput);
            checkValidCarNames(carNames);
            Map<String, Car> cars = carNames.stream()
                    .collect(Collectors.toMap(carName->carName, carName -> new Car(carName)));
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

    public Car getCarWithName(String carName) {
        if (cars.isPresent()) {
            return cars.get().get(carName);
        }
        throw new MethodNotAllowedException();
    }

    public boolean isNotSucessfullyMade() {
        return !cars.isPresent();
    }
}
