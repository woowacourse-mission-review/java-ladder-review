import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private Map<String, Car> cars;
    public Cars(String userInput) {
        List<String> carNames = parse(userInput);
        checkValidCarNames(carNames);
        this.cars = carNames.stream()
                .collect(Collectors.toMap(carName->carName, carName -> new Car(carName)));
    }

    private void checkValidCarNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() != carNames.size()) {
            throw new InvalidCarNameException();
        }
    }

    private List<String> parse(String userInput) {
        String preParseCarNames = userInput.split(RacingGameInputAsker.DELIMITER)[RacingGameInputAsker.FIRST_INEXT];
        return new ArrayList<>(Arrays.asList(preParseCarNames.split(",")));
    }

    public int size() {
        return cars.size();
    }

    public Car getCarWithName(String carName) {
        return cars.get(carName);
    }
}
