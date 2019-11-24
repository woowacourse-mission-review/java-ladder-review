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
        MeetingPoint point1 = new MeetingPoint(1, true);
        MeetingPoint point2 = new MeetingPoint(2, false);
        MeetingPoint point3 = new MeetingPoint(3, true);
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
        MeetingPoint point1 = new MeetingPoint(1, false);
        MeetingPoint point2 = new MeetingPoint(2, true);
        MeetingPoint point3 = new MeetingPoint(3, false);
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