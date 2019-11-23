package ladder.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    void 생성_테스트() {
        String inputNames = "bedi, cu, pobi";
        Players players = Players.of(inputNames);

        assertThat(players.size()).isEqualTo(3);
    }
}