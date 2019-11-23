package laddergame.service;

import laddergame.domain.ladderplayer.LadderPlayer;
import laddergame.domain.ladderplayer.LadderPlayers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameService {

    private static final String LADDER_PLAYER_NAME_DELIMITER = ",";

    public LadderPlayers createPlayers(final String playerNames) {
        List<LadderPlayer> ladderPlayers = parsePlayerNames(playerNames);

        return LadderPlayers.create(ladderPlayers);
    }

    private List<LadderPlayer> parsePlayerNames(final String playerNames) {
        String[] playerNameTokens = playerNames.split(LADDER_PLAYER_NAME_DELIMITER);
        return Arrays.stream(playerNameTokens)
                .map(String::trim)
                .map(LadderPlayer::from)
                .collect(Collectors.toList());
    }
}
