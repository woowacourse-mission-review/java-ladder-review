package games.laddergame;

import games.laddergame.domain.GameComponents;
import games.laddergame.domain.Player;
import games.laddergame.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    @DisplayName("Player들이 잘만들어지는 테스트")
    void register_players_as_components() {
        LadderGame game = new LadderGame();
        GameComponents gameComponents = game.registerComponents("java,scala,pytho", Player::new);

        assertThat(gameComponents.getComponentAt(0).getName()).isEqualTo("java");
        assertThat(gameComponents.getComponentAt(0).getPosition()).isEqualTo(0);
        assertThat(gameComponents.getComponentAt(1).getName()).isEqualTo("scala");
        assertThat(gameComponents.getComponentAt(1).getPosition()).isEqualTo(1);
        assertThat(gameComponents.getComponentAt(2).getName()).isEqualTo("pytho");
        assertThat(gameComponents.getComponentAt(2).getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("Prize들이 잘만들어지는 테스트")
    void register_prizes_as_components() {
        LadderGame game = new LadderGame();
        GameComponents gameComponents = game.registerComponents("win,lose,win", Prize::new);

        assertThat(gameComponents.getComponentAt(0).getName()).isEqualTo("win");
        assertThat(gameComponents.getComponentAt(0).getPosition()).isEqualTo(0);
        assertThat(gameComponents.getComponentAt(1).getName()).isEqualTo("lose");
        assertThat(gameComponents.getComponentAt(1).getPosition()).isEqualTo(1);
        assertThat(gameComponents.getComponentAt(2).getName()).isEqualTo("win");
        assertThat(gameComponents.getComponentAt(2).getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("Player들이 잘만들어지는 테스트 고정된 포지션")
    void register_players_as_components_with_fixed_position() {
        LadderGame game = new LadderGame();
        GameComponents gameComponents = game.registerComponents("win,lose,win", (name, position) -> new Player(name, 0));

        assertThat(gameComponents.getComponentAt(0).getName()).isEqualTo("win");
        assertThat(gameComponents.getComponentAt(0).getPosition()).isEqualTo(0);
        assertThat(gameComponents.getComponentAt(1).getName()).isEqualTo("lose");
        assertThat(gameComponents.getComponentAt(1).getPosition()).isEqualTo(0);
        assertThat(gameComponents.getComponentAt(2).getName()).isEqualTo("win");
        assertThat(gameComponents.getComponentAt(2).getPosition()).isEqualTo(0);
    }

}