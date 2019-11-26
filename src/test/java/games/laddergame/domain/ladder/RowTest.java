package games.laddergame.domain.ladder;

import games.laddergame.domain.GameComponents;
import games.laddergame.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RowTest {
    @Test
    @DisplayName("한 개의 ROW타기 테스트")
    void play_current_row1() {
        MeetingBridge point1 = new MeetingBridge(1, true);
        MeetingBridge point2 = new MeetingBridge(2, false);
        MeetingBridge point3 = new MeetingBridge(3, true);
        Row row = new Row(Arrays.asList(point1, point2, point3));

        Player player1 = new Player("java", 0);
        Player player2 = new Player("ruby", 1);
        Player player3 = new Player("css", 2);
        Player player4 = new Player("jaso", 3);
        GameComponents players = new GameComponents(Arrays.asList(player1, player2, player3, player4), true);

        row.playCurrentRow(players);

        assertThat(players.getComponentAt(0).getPosition()).isEqualTo(1);
        assertThat(players.getComponentAt(1).getPosition()).isEqualTo(0);
        assertThat(players.getComponentAt(2).getPosition()).isEqualTo(3);
        assertThat(players.getComponentAt(3).getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("한 개의 ROW타기 테스트")
    void play_current_row2() {
        MeetingBridge point1 = new MeetingBridge(1, false);
        MeetingBridge point2 = new MeetingBridge(2, true);
        MeetingBridge point3 = new MeetingBridge(3, false);
        Row row = new Row(Arrays.asList(point1, point2, point3));

        Player player1 = new Player("java", 0);
        Player player2 = new Player("ruby", 1);
        Player player3 = new Player("css", 2);
        Player player4 = new Player("jaso", 3);
        GameComponents players = new GameComponents(Arrays.asList(player1, player2, player3, player4), true);

        row.playCurrentRow(players);

        assertThat(players.getComponentAt(0).getPosition()).isEqualTo(0);
        assertThat(players.getComponentAt(1).getPosition()).isEqualTo(2);
        assertThat(players.getComponentAt(2).getPosition()).isEqualTo(1);
        assertThat(players.getComponentAt(3).getPosition()).isEqualTo(3);
    }
}