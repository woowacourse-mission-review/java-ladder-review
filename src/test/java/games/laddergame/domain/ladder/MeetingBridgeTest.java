package games.laddergame.domain.ladder;

import games.laddergame.domain.GameComponents;
import games.laddergame.domain.Player;
import games.laddergame.exception.MeetingBridgePositionError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MeetingBridgeTest {
    @Test
    @DisplayName("MeetingBridge생성 테스트1")
    void meeting_ponint_construct_test() {
        MeetingBridge bridge = new MeetingBridge(1, true);

        assertThat(bridge.getPosition()).isEqualTo(1);
        assertThat(bridge.isSwap()).isTrue();
    }

    @Test
    @DisplayName("오류, MeetingBridge생성 테스트")
    void fail_meeting_ponint_construct_test() {
        assertThrows(MeetingBridgePositionError.class, () -> new MeetingBridge(0, true));
    }

    @Test
    @DisplayName("swap함수 확인")
    void swap() {
        Player player1 = new Player("java", 0);
        Player player2 = new Player("ruby", 1);
        Player player3 = new Player("css", 2);
        Player player4 = new Player("jaso", 3);
        GameComponents players = new GameComponents(Arrays.asList(player1, player2, player3, player4), true);

        MeetingBridge meetingBridge = new MeetingBridge(1, true);
        meetingBridge.swap(players);
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

        MeetingBridge meetingBridge = new MeetingBridge(2, true);
        meetingBridge.swap(players);
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

        MeetingBridge meetingBridge = new MeetingBridge(3, true);
        meetingBridge.swap(players);
        assertThat(players.getComponentAt(2).getPosition()).isEqualTo(3);
        assertThat(players.getComponentAt(3).getPosition()).isEqualTo(2);
    }
}