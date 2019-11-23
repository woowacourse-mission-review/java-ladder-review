package ladder.console;

import ladder.console.view.InputView;
import ladder.console.view.OutputView;
import ladder.domain.LadderGameInfo;
import ladder.domain.Result;
import ladder.domain.ladder.DefaultLadderFactory;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderFactory;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
import ladder.service.LadderGameService;

import java.util.List;

import static ladder.domain.LadderGameInfo.ALL_RESULTS;

public class ConsoleApp {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        final LadderFactory ladderFactory = new DefaultLadderFactory();
        final LadderGameService ladderGameService = new LadderGameService(ladderFactory);

        final Players players = ladderGameService.createPlayers(inputView.inputNames());
        final Rewards rewards = ladderGameService.createRewards(inputView.inputRewards());
        final int height = inputView.inputHeight();

        final Ladder ladder = ladderGameService.createLadder(height, players.size());

        outputView.printPlayers(players);
        outputView.printLadder(ladder);
        outputView.printRewards(rewards);

        final LadderGameInfo ladderGameInfo = ladderGameService.createLadderGameInfo(players, rewards, ladder);

        String playerName = "";
        while (!ALL_RESULTS.equals(playerName)) {
            playerName = inputView.inputResultPlayerName();
            final List<Result> results = ladderGameService.createResults(ladderGameInfo, playerName);
            outputView.printResult(results);
        }
    }


}
