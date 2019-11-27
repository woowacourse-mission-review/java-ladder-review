package ghostleg.view;

import ghostleg.domain.*;

import java.util.List;
import java.util.Map;

public interface GhostLegOutputView {
    void printPlayers(Players players);
    void printLadder(Ladder ladder);
    void printRewards(Rewards rewards);
    void printResult(Reward result);
    void printAllResults(Map<PlayerName, Reward> results);
}
