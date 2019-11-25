package laddergame.service;

import laddergame.domain.LadderGame;
import laddergame.domain.LadderHeight;
import laddergame.domain.laddergoal.LadderGoal;
import laddergame.domain.laddergoal.LadderGoals;
import laddergame.domain.ladderplayer.LadderPlayer;
import laddergame.domain.ladderplayer.LadderPlayers;
import laddergame.domain.result.LadderGameResult;
import laddergame.exception.ReservedKeywordException;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderGameService {

    private static final String LADDER_GAME_NAME_DELIMITER = ",";

    public LadderPlayers createPlayers(final String playerNames) {
        List<LadderPlayer> ladderPlayerList = parseNames(playerNames, LadderPlayer::from);

        LadderPlayers ladderPlayers = LadderPlayers.create(ladderPlayerList);
        checkReservedKeywords(ladderPlayers);

        return ladderPlayers;
    }

    private void checkReservedKeywords(final LadderPlayers ladderPlayers) {
        List<String> allReservedKeywords = LadderGameReservedKeywords.getAllKeywords();
        allReservedKeywords.forEach(keyword -> {
            if (ladderPlayers.hasPlayerWithName(keyword)) {
                throw new ReservedKeywordException(keyword);
            }
        });
    }

    public LadderGoals createGoals(final String goalNames, final int sizeOfLadderPlayers) {
        List<LadderGoal> ladderGoals = parseNames(goalNames, LadderGoal::from);

        return LadderGoals.create(ladderGoals, sizeOfLadderPlayers);
    }

    private <T> List<T> parseNames(final String names, final Function<String, T> creationFunction) {
        String[] nameTokens = names.split(LADDER_GAME_NAME_DELIMITER);

        return Arrays.stream(nameTokens)
                .map(String::trim)
                .map(creationFunction)
                .collect(Collectors.toList());
    }

    public LadderHeight createHeight(final String ladderHeight) {
        return LadderHeight.from(ladderHeight);
    }

    public LadderGame createLadderGame(final LadderPlayers ladderPlayers, final LadderGoals ladderGoals, final LadderHeight ladderHeight) {
        return LadderGame.createWithRandomCreationStrategy(ladderPlayers, ladderGoals, ladderHeight);
    }

    public LadderGameResult proceedGame(final LadderGame ladderGame) {
        return ladderGame.proceed();
    }
}
