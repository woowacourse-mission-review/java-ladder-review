package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    @Test
    @DisplayName("Direction 최소 사이즈 미만 예외처리")
    void createException01() {
        List<Direction> directions = Arrays.asList(Direction.STRAIGHT);

        assertThrows(IllegalArgumentException.class, () -> Line.of(directions));
    }

    @Test
    @DisplayName("첫번째 줄 왼쪽 방향이면 예외처리")
    void createException02() {
        List<Direction> directions = Arrays.asList(Direction.LEFT, Direction.STRAIGHT);

        assertThrows(IllegalArgumentException.class, () -> Line.of(directions));
    }

    @Test
    @DisplayName("마지막 줄 오른족 방향이면 예외처리")
    void createException03() {
        List<Direction> directions = Arrays.asList(Direction.STRAIGHT, Direction.RIGHT);

        assertThrows(IllegalArgumentException.class, () -> Line.of(directions));
    }

    @Test
    @DisplayName("방향 일치하지 않으면 예외처리 (오른쪽, 직선)")
    void createException04() {
        List<Direction> directions = Arrays.asList(Direction.RIGHT, Direction.STRAIGHT);

        assertThrows(IllegalArgumentException.class, () -> Line.of(directions));
    }

    @Test
    @DisplayName("방향 일치하지 않으면 예외처리 (오른쪽, 오른족)")
    void createException05() {
        List<Direction> directions = Arrays.asList(Direction.RIGHT, Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT);

        assertThrows(IllegalArgumentException.class, () -> Line.of(directions));
    }

    @Test
    @DisplayName("방향 일치하지 않으면 예외처리 (왼쪽, 왼쪽)")
    void createException06() {
        List<Direction> directions = Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.LEFT);

        assertThrows(IllegalArgumentException.class, () -> Line.of(directions));
    }

    @Test
    @DisplayName("방향 일치하지 않으면 예외처리 (직선, 왼쪽)")
    void createException07() {
        List<Direction> directions = Arrays.asList(Direction.STRAIGHT, Direction.LEFT);

        assertThrows(IllegalArgumentException.class, () -> Line.of(directions));
    }

    @Test
    @DisplayName("정상적인 입력 생성 확인")
    void createTest() {
        List<Direction> directions = Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT);

        assertDoesNotThrow(() -> Line.of(directions));
    }

    @Test
    void moveTest() {
        // given
        int expected = 0;
        Position position = Position.from(1);
        List<Direction> directions = Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT);
        Line line = Line.of(directions);

        // when
        int actual = line.move(position).get();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}