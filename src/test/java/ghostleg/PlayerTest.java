package ghostleg;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {
    @Test
    void moveRight() {
        Player testPlayer = new Player(new PlayerName("moomin"), new Position(0, new NumOfPlayers(2)));
        testPlayer.move(Direction.RIGHT);
        assertThat(testPlayer.getPosition().getValue()).isEqualTo(1);
    }

    @Test
    void moveLeft() {
        Player testPlayer = new Player(new PlayerName("moomin"), new Position(1, new NumOfPlayers(2)));
        testPlayer.move(Direction.LEFT);
        assertThat(testPlayer.getPosition().getValue()).isEqualTo(0);
    }

    @Test
    void moveStraight() {
        Player testPlayer = new Player(new PlayerName("moomin"), new Position(1, new NumOfPlayers(2)));
        testPlayer.move(Direction.STRAIGHT);
        assertThat(testPlayer.getPosition().getValue()).isEqualTo(1);
    }

    @Test
    void cannotMoveLowerThanZero() {
        Player testPlayer = new Player(new PlayerName("moomin"), new Position(0, new NumOfPlayers(2)));
        assertThrows(IllegalArgumentException.class, () -> testPlayer.move(Direction.LEFT));
    }

    @Test
    void cannotMoveRightThanTheNumberOfPlayers() {
        Player testPlayer = new Player(new PlayerName("moomin"), new Position(1, new NumOfPlayers(2)));
        assertThrows(IllegalArgumentException.class, () -> testPlayer.move(Direction.RIGHT));
    }
}