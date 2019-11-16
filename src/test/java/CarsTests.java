import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTests {
    @Test
    void cars_construcotrs_tests() {
        String userInput = "abc,cda,bba%&*5";
        Cars cars = new Cars(userInput);

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.getCarWithName("abc").getCarName()).isEqualTo("abc");
    }
}
