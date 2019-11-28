package ladder.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayersTest {

    @Test
    void 생성_테스트() {
        String inputNames = "bedi, cu, pobi";
        Players players = Players.of(inputNames);

        assertThat(players.getByPlayerName("bedi")).isNotNull();
        assertThat(players.getByPlayerName("cu")).isNotNull();
        assertThat(players.getByPlayerName("pobi")).isNotNull();
    }

    @Test
    void 최소_인원수_미만_예외처리() {
        String inputNames = "bedi";

        assertThrows(IllegalArgumentException.class, () -> Players.of(inputNames));
    }

    @Test
    void 이름_중복_예외처리() {
        String inputNames = "bedi, cu, bedi";

        assertThrows(IllegalArgumentException.class, () -> Players.of(inputNames));
    }

    @Test
    void getByPlayerName_없는_이름_예외처리() {
        String inputNames = "bedi, cu, pobi";
        Players players = Players.of(inputNames);

        assertThrows(IllegalArgumentException.class, () -> players.getByPlayerName("qwe"));
    }
}