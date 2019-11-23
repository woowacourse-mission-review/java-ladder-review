package ladder.domain.player;

import ladder.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void 생성_테스트() {
        PlayerName name = PlayerName.from("bedi");
        Position position = Position.from(0);
        Player player = Player.of(name, position);

        assertThat(player.getName()).isEqualTo(name.get());
        assertThat(player.getPosition()).isEqualTo(position);
    }
}