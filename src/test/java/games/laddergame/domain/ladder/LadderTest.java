package games.laddergame.domain.ladder;

import games.laddergame.domain.GameComponents;
import games.laddergame.domain.Player;
import games.laddergame.domain.ladder.ladderrowmaker.LadderRowMaker;
import games.laddergame.domain.ladder.ladderrowmaker.LadderRowMakers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리 생성 테스트 사이즈 체크")
    void construct_ladder() {
        MeetingPoint point1 = new MeetingPoint(1, true);
        MeetingPoint point2 = new MeetingPoint(2, false);
        MeetingPoint point3 = new MeetingPoint(3, true);
        Row row1 = new Row(Arrays.asList(point1, point2, point3));
        Row row2 = new Row(Arrays.asList(point1, point2, point3));
        Row row3 = new Row(Arrays.asList(point1, point2, point3));
        Row row4 = new Row(Arrays.asList(point1, point2, point3));

        List<Row> checkRows = Arrays.asList(row1, row2, row3, row4);


        Ladder ladder = new Ladder(3, 4, new LadderRowMakers(3,4));

        assertThat(ladder.getHeight()).isEqualTo(4);
        assertThat(ladder.getWidth()).isEqualTo(3);
    }

    @Test
    @DisplayName("사다리 생성 테스트 내용 체크")
    void construct_ladder2() {
        MeetingPoint point1 = new MeetingPoint(1, true);
        MeetingPoint point2 = new MeetingPoint(2, false);
        MeetingPoint point3 = new MeetingPoint(3, true);
        Row row1 = new Row(Arrays.asList(point1, point2, point3));
        Row row2 = new Row(Arrays.asList(point1, point2, point3));
        Row row3 = new Row(Arrays.asList(point1, point2, point3));
        Row row4 = new Row(Arrays.asList(point1, point2, point3));

        List<Row> checkRows = Arrays.asList(row1, row2, row3, row4);
        List<LadderRowMaker> rowMakers = Arrays.asList(()->row1, ()->row2, ()->row3, ()->row4);

        Ladder ladder = new Ladder(3, 4, new LadderRowMakers(rowMakers));

        assertThat(ladder.getHeight()).isEqualTo(4);
        assertThat(ladder.getWidth()).isEqualTo(4);
        assertThat(ladder.getLadder()).isEqualTo(checkRows);
    }

    @Test
    @DisplayName("사다리 타기 테스트")
    void climb_down_ladder_test() {
        MeetingPoint point1 = new MeetingPoint(1, true);
        MeetingPoint point2 = new MeetingPoint(2, false);
        MeetingPoint point3 = new MeetingPoint(3, true);
        MeetingPoint point4 = new MeetingPoint(4, false);
        Row row1 = new Row(Arrays.asList(point1, point2, point3, point4));

        MeetingPoint point5 = new MeetingPoint(1, false);
        MeetingPoint point6 = new MeetingPoint(2, true);
        MeetingPoint point7 = new MeetingPoint(3, false);
        MeetingPoint point8 = new MeetingPoint(4, true);
        Row row2 = new Row(Arrays.asList(point5, point6, point7, point8));

        List<LadderRowMaker> rowMakers = Arrays.asList(()->row1,()->row2, ()->row2, ()->row1);
        Ladder ladder = new Ladder(5, 4, new LadderRowMakers(rowMakers));

        Player player1 = new Player("java", 0);
        Player player2 = new Player("ruby", 1);
        Player player3 = new Player("css", 2);
        Player player4 = new Player("jaso", 3);
        Player player5 = new Player ("html", 4);
        GameComponents players = new GameComponents(Arrays.asList(player1, player2,player3, player4, player5), true);

        ladder.climbDownLadder(players, null);
        assertThat(players.getComponentAt(0).getPosition()).isEqualTo(0);
        assertThat(players.getComponentAt(1).getPosition()).isEqualTo(1);
        assertThat(players.getComponentAt(2).getPosition()).isEqualTo(2);
        assertThat(players.getComponentAt(3).getPosition()).isEqualTo(3);
        assertThat(players.getComponentAt(4).getPosition()).isEqualTo(4);
    }
}