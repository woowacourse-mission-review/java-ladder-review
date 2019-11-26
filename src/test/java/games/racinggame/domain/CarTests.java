package games.racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTests {
    @Test
    @DisplayName("자동차가 제대로 움직이는지 테스트")
    void car_move_test1() {
        Car car = new Car("jm", 10);

        car.move(7);
        assertThat(car.getPosition()).isEqualTo(11);
    }

    @Test
    @DisplayName("자동차가 제대로 움직이는지 테스트")
    void car_move_test2() {
        Car car = new Car("jm", 10);

        car.move(-7);
        assertThat(car.getPosition()).isEqualTo(10);
    }
}
