package laddergame.service;

import laddergame.domain.player.LadderPlayer;
import laddergame.domain.player.LadderPlayers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameService {

    public LadderPlayers createPlayers(final String playerNameInputs) {
        String[] playerNameTokens = playerNameInputs.split(",");
        List<LadderPlayer> ladderPlayers = Arrays.stream(playerNameTokens)
                .map(String::trim)
                .map(LadderPlayer::from)
                .collect(Collectors.toList());

        return LadderPlayers.create(ladderPlayers);
    }
}
