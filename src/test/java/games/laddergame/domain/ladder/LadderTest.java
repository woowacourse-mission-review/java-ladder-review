package games.laddergame.domain.ladder;

import games.laddergame.domain.GameComponents;
import games.laddergame.domain.Player;
import games.laddergame.domain.Prize;
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
        MeetingBridge bridge1 = new MeetingBridge(1, true);
        MeetingBridge bridge2 = new MeetingBridge(2, false);
        MeetingBridge bridge3 = new MeetingBridge(3, true);

        Ladder ladder = new Ladder(4, new LadderRowMakers(3, 4));

        assertThat(ladder.getHeight()).isEqualTo(4);
        assertThat(ladder.getWidth()).isEqualTo(3);
    }

    @Test
    @DisplayName("사다리 생성 테스트 내용 체크")
    void construct_ladder2() {
        MeetingBridge bridge1 = new MeetingBridge(1, true);
        MeetingBridge bridge2 = new MeetingBridge(2, false);
        MeetingBridge bridge3 = new MeetingBridge(3, true);
        Row row1 = new Row(Arrays.asList(bridge1, bridge2, bridge3));
        Row row2 = new Row(Arrays.asList(bridge1, bridge2, bridge3));
        Row row3 = new Row(Arrays.asList(bridge1, bridge2, bridge3));
        Row row4 = new Row(Arrays.asList(bridge1, bridge2, bridge3));

        List<Row> checkRows = Arrays.asList(row1, row2, row3, row4);
        List<LadderRowMaker> rowMakers = Arrays.asList(() -> row1, () -> row2, () -> row3, () -> row4);

        Ladder ladder = new Ladder(4, new LadderRowMakers(rowMakers));

        assertThat(ladder.getHeight()).isEqualTo(4);
        assertThat(ladder.getWidth()).isEqualTo(4);
        assertThat(ladder.getLadder()).isEqualTo(checkRows);
    }

    @Test
    @DisplayName("사다리 타기 테스트")
    void climb_down_ladder_test() {
        MeetingBridge bridge1 = new MeetingBridge(1, true);
        MeetingBridge bridge2 = new MeetingBridge(2, false);
        MeetingBridge bridge3 = new MeetingBridge(3, true);
        MeetingBridge bridge4 = new MeetingBridge(4, false);
        Row row1 = new Row(Arrays.asList(bridge1, bridge2, bridge3, bridge4));

        MeetingBridge bridge5 = new MeetingBridge(1, false);
        MeetingBridge bridge6 = new MeetingBridge(2, true);
        MeetingBridge bridge7 = new MeetingBridge(3, false);
        MeetingBridge bridge8 = new MeetingBridge(4, true);
        Row row2 = new Row(Arrays.asList(bridge5, bridge6, bridge7, bridge8));

        List<LadderRowMaker> rowMakers = Arrays.asList(() -> row1, () -> row2, () -> row2, () -> row1);
        Ladder ladder = new Ladder(4, new LadderRowMakers(rowMakers));

        Player player1 = new Player("java", 0);
        Player player2 = new Player("ruby", 1);
        Player player3 = new Player("css", 2);
        Player player4 = new Player("jaso", 3);
        Player player5 = new Player("html", 4);
        GameComponents players = new GameComponents(Arrays.asList(player1, player2, player3, player4, player5), true);

        Prize prize1 = new Prize("java", 0);
        Prize prize2 = new Prize("ruby", 1);
        Prize prize3 = new Prize("css", 2);
        Prize prize4 = new Prize("jaso", 3);
        Prize prize5 = new Prize("html", 4);
        GameComponents prizes = new GameComponents(Arrays.asList(prize1, prize2, prize3, prize4, prize5), false);

        ladder.climbDownLadder(players, prizes);
        assertThat(players.getComponentAt(0).getPosition()).isEqualTo(0);
        assertThat(players.getComponentAt(1).getPosition()).isEqualTo(1);
        assertThat(players.getComponentAt(2).getPosition()).isEqualTo(2);
        assertThat(players.getComponentAt(3).getPosition()).isEqualTo(3);
        assertThat(players.getComponentAt(4).getPosition()).isEqualTo(4);
    }
}