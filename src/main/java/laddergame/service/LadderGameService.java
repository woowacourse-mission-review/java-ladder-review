package laddergame.service;

import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameService {

    public Players createPlayers(final String playerNameInputs) {
        String[] playerNameTokens = playerNameInputs.split(",");
        List<Player> players = Arrays.stream(playerNameTokens)
                .map(String::trim)
                .map(Player::of)
                .collect(Collectors.toList());

        return Players.create(players);
    }
}
