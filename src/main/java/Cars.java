import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private Map<String, Car> cars;
    public Cars(String userInput) {
        List<String> carNames = parse(userInput);
        this.cars = carNames.stream()
                .collect(Collectors.toMap(carName->carName, carName -> new Car(carName)));
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
