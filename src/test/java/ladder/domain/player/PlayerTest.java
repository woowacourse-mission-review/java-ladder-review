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

    @Test
    void 이름으로_논리적_동치성_테스트() {
        PlayerName name = PlayerName.from("bedi");
        Player player1 = Player.of(name, Position.from(0));
        Player player2 = Player.of(name, Position.from(1));

        assertThat(player1 != player2).isTrue();
        assertThat(player1).isEqualTo(player2);
    }
}