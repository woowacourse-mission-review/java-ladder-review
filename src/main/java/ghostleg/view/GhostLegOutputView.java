package ghostleg.view;

import ghostleg.domain.Ladder;
import ghostleg.domain.Player;
import ghostleg.domain.Result;
import ghostleg.domain.Reward;

import java.util.List;

public interface GhostLegOutputView {
    void printPlayers(List<Player> players);
    void printLadder(Ladder ladder);
    void printRewards(List<Reward> rewards);
    void printResult(Result result);
    void printAllResults(List<Result> results);
}
