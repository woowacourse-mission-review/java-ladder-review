package games.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTests {
    @Test
    void cars_constructors_tests() {
        String userInput = "cda,bba,abc";
        Cars cars = new Cars(userInput);

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.getCarAt(0).getCarName()).isEqualTo("cda");
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상일 때 테스트")
    void fail_cars_constructors_tests1() {
        String userInput = "abcdefhihkljkjlasdf,abc,cda";
        Cars cars = new Cars(userInput);
        assertThat(cars.isNotSuccessfullyMade()).isTrue();
    }

    @Test
    @DisplayName("자동차 이름이 1자 이하일 때 테스트")
    void fail_cars_constructors_tests2() {
        String userInput = "abc,,cda";
        Cars cars = new Cars(userInput);
        assertThat(cars.isNotSuccessfullyMade()).isTrue();
    }

    @Test
    @DisplayName("자동차 이름이 중복있을 때 테스트")
    void fail_cars_constructors_tests3() {
        String userInput = "abc,abc,cda";
        Cars cars = new Cars(userInput);
        assertThat(cars.isNotSuccessfullyMade()).isTrue();
    }

    @Test
    @DisplayName("자동차 이름에 특수문자 있을 때 테스트")
    void fail_cars_constructors_tests4() {
        String userInput = "abc,abc,cda";
        Cars cars = new Cars(userInput);
        assertThat(cars.isNotSuccessfullyMade()).isTrue();
    }

    @Test
    @DisplayName("자동차들 안움직임 테스트")
    void move_cars_test1() {
        Car car1 = new Car("jm", 10);
        Car car2 = new Car("im", 11);

        Cars cars = new Cars(Arrays.asList(car1, car2));
        List<Integer> instructions = Arrays.asList(3, 1);

        cars.movePosition(instructions);

        assertThat(cars.getCarAt(0).getPosition()).isEqualTo(10);
        assertThat(cars.getCarAt(1).getPosition()).isEqualTo(11);
    }

    @Test
    @DisplayName("자동차들 움직임 테스트")
    void move_cars_test2() {
        Car car1 = new Car("jm", 10);
        Car car2 = new Car("im", 11);

        Cars cars = new Cars(Arrays.asList(car1, car2));
        List<Integer> instructions = Arrays.asList(9, 10);

        cars.movePosition(instructions);

        assertThat(cars.getCarAt(0).getPosition()).isEqualTo(11);
        assertThat(cars.getCarAt(1).getPosition()).isEqualTo(12);
    }

    @Test
    @DisplayName("SnapShot제대로 만드닌지 테스트")
    void make_snapshot_test() {
        Car car1 = new Car("jm", 10);
        Car car2 = new Car("im", 11);

        Cars cars = new Cars(Arrays.asList(car1, car2));

        CarStatusSnapShot checkCarStatusSnapShot = new CarStatusSnapShot(Arrays.asList("jm", "im"), Arrays.asList(10, 11));

        assertThat(cars.makeSnapShotsOfCars()).isEqualTo(checkCarStatusSnapShot);
    }

    @Test
    @DisplayName("SnapShot제대로 만드닌지 테스트2")
    void make_snapshot_test2() {
        Car car1 = new Car("jm", 10);
        Car car2 = new Car("im", 11);

        Cars cars = new Cars(Arrays.asList(car1, car2));
        List<Integer> instructions = Arrays.asList(10, 11);
        cars.movePosition(instructions);

        CarStatusSnapShot checkCarStatusSnapShot = new CarStatusSnapShot(Arrays.asList("jm", "im"), Arrays.asList(11, 12));

        assertThat(cars.makeSnapShotsOfCars()).isEqualTo(checkCarStatusSnapShot);
    }

    @Test
    @DisplayName("우승자 제대로 찾는지 확인")
    void get_winners_tests() {
        Car car1 = new Car("jm", 10);
        Car car2 = new Car("im", 11);

        Cars cars = new Cars(Arrays.asList(car1, car2));
        List<Integer> instructions = Arrays.asList(10, 11);
        cars.movePosition(instructions);

        assertThat(cars.getWinners()).isEqualTo(Arrays.asList("im"));
    }

    @Test
    @DisplayName("우승자 제대로 찾는지 확인2")
    void get_winners_tests2() {
        Car car1 = new Car("jm", 11);
        Car car2 = new Car("im", 11);

        Cars cars = new Cars(Arrays.asList(car1, car2));
        List<Integer> instructions = Arrays.asList(10, 11);
        cars.movePosition(instructions);

        assertThat(cars.getWinners()).isEqualTo(Arrays.asList("jm", "im"));
    }
}
