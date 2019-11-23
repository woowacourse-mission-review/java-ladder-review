package ladder.service;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.player.Players;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LadderGameServiceTest {

    @Mock
    private LadderFactory ladderFactory;

    @InjectMocks
    private LadderGameService ladderGameService;

    @Test
    void createPlayersTest() {
        String inputNames = "bedi,pobi,cu";
        Players players = ladderGameService.createPlayers(inputNames);

        assertThat(players.size()).isEqualTo(3);
    }

    @Test
    void createLadderTest() {
        // given
        int height = 2;
        int countOfPlayers = 3;
        Ladder mockLadder = mock(Ladder.class);
        when(ladderFactory.create(Height.from(height), countOfPlayers)).thenReturn(mockLadder);

        // when
        Ladder createdLadder = ladderGameService.createLadder(height, countOfPlayers);

        // then
        assertThat(createdLadder).isEqualTo(mockLadder);
    }
}