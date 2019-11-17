import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTests {
    @Test
    void cars_constructors_tests() {
        String userInput = "cda,bba,abc%&*5";
        Cars cars = new Cars(userInput);

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.getCarWithName("abc").getCarName()).isEqualTo("abc");
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상일 때 테스트")
    void fail_cars_constructors_tests1() {
        String userInput = "abcdefhihkljkjlasdf,abc,cda%&*7";
        assertThrows(InvalidCarNameException.class, ()-> new Cars(userInput));
    }

    @Test
    @DisplayName("자동차 이름이 1자 이하일 때 테스트")
    void fail_cars_constructors_tests2() {
        String userInput = "abc,,cda%&*7";
        assertThrows(InvalidCarNameException.class, ()-> new Cars(userInput));
    }

    @Test
    @DisplayName("자동차 이름이 중복있을 때 테스트")
    void fail_cars_constructors_tests3() {
        String userInput = "abc,abc,cda%&*7";
        assertThrows(InvalidCarNameException.class, ()-> new Cars(userInput));
    }

    @Test
    @DisplayName("자동차 이름에 특수문자 있을 때 테스트")
    void fail_cars_constructors_tests4() {
        String userInput = "abc,abc,cda%&*7";
        assertThrows(InvalidCarNameException.class, ()-> new Cars(userInput));
    }
}
