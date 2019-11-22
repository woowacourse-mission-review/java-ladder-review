package games.library;

import games.laddergame.domain.Player;
import games.laddergame.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ObjectMakingTemplateTest {
    @Test
    @DisplayName("라이브러리 제대로 작동하는지 확인, Player일때")
    void template_test1() {
        ObjectMakingTemplate objectMakingTemplate = ObjectMakingTemplate.getInstance();
        String usereInput = "java,ruby,css";

        List<Player> players = objectMakingTemplate.createMultipleObjects(usereInput, ((name, position) -> new Player(name, position)));
        assertThat(players.get(0).getName()).isEqualTo("java");
        assertThat(players.get(0).getPosition()).isEqualTo(0);
        assertThat(players.get(1).getName()).isEqualTo("ruby");
        assertThat(players.get(1).getPosition()).isEqualTo(1);
        assertThat(players.get(2).getName()).isEqualTo("css");
        assertThat(players.get(2).getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("라이브러리 제대로 작동하는지 확, Prizes일때")
    void template_test2() {
        ObjectMakingTemplate objectMakingTemplate = ObjectMakingTemplate.getInstance();
        String usereInput = "WIN!,win,lose";

        List<Prize> prizes = objectMakingTemplate.createMultipleObjects(usereInput, ((name, position) -> new Prize(name, position)));
        assertThat(prizes.get(0).getName()).isEqualTo("WIN!");
        assertThat(prizes.get(0).getPosition()).isEqualTo(0);
        assertThat(prizes.get(1).getName()).isEqualTo("win");
        assertThat(prizes.get(1).getPosition()).isEqualTo(1);
        assertThat(prizes.get(2).getName()).isEqualTo("lose");
        assertThat(prizes.get(2).getPosition()).isEqualTo(2);
    }
}