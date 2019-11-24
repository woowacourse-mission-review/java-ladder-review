package games.laddergame.domain.ladder;

import games.laddergame.domain.GameComponents;
import games.laddergame.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MeetingPointTest {
    @Test
    @DisplayName("MeetingPoint생성 테스트1")
    void meeting_ponint_construct_test() {
        MeetingPoint point = new MeetingPoint(1, true);

        assertThat(point.getPosition()).isEqualTo(1);
        assertThat(point.isSwap()).isTrue();
    }

    @Test
    @DisplayName("오류, MeetingPoint생성 테스트")
    void fail_meeting_ponint_construct_test() {
        assertThrows(IllegalArgumentException.class, () -> new MeetingPoint(0, true));
    }

    @Test
    @DisplayName("swap함수 확인")
    void swap() {
        Player player1 = new Player("java", 0);
        Player player2 = new Player("ruby", 1);
        Player player3 = new Player("css", 2);
        Player player4 = new Player("jaso", 3);
        GameComponents players = new GameComponents(Arrays.asList(player1, player2, player3, player4), true);

        MeetingPoint point = new MeetingPoint(1, true);
        point.swap(players);
        assertThat(players.getComponentAt(0).getPosition()).isEqualTo(1);
        assertThat(players.getComponentAt(1).getPosition()).isEqualTo(0);

    }

    @Test
    @DisplayName("swap함수 확인")
    void swap2() {
        Player player1 = new Player("java", 0);
        Player player2 = new Player("ruby", 1);
        Player player3 = new Player("css", 2);
        Player player4 = new Player("jaso", 3);
        GameComponents players = new GameComponents(Arrays.asList(player1, player2, player3, player4), true);

        MeetingPoint point = new MeetingPoint(2, true);
        point.swap(players);
        assertThat(players.getComponentAt(1).getPosition()).isEqualTo(2);
        assertThat(players.getComponentAt(2).getPosition()).isEqualTo(1);

    }

    @Test
    @DisplayName("swap함수 확인")
    void swap3() {
        Player player1 = new Player("java", 0);
        Player player2 = new Player("ruby", 1);
        Player player3 = new Player("css", 2);
        Player player4 = new Player("jaso", 3);
        GameComponents players = new GameComponents(Arrays.asList(player1, player2, player3, player4), true);

        MeetingPoint point = new MeetingPoint(3, true);
        point.swap(players);
        assertThat(players.getComponentAt(2).getPosition()).isEqualTo(3);
        assertThat(players.getComponentAt(3).getPosition()).isEqualTo(2);
    }
}