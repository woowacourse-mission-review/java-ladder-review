package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final int playersCount;
    private final Height height;
    private final HorizonLines horizonLines;

    public Ladder(final int playersCount, final Height height) {
        this.playersCount = playersCount;
        this.height = height;
        horizonLines = createHorizonLines();
    }

    private HorizonLines createHorizonLines() {
        List<HorizonLine> horizonLines = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            horizonLines.add(createHorizonLine());
        }

        return new HorizonLines(horizonLines);
    }

    private HorizonLine createHorizonLine() {
        List<LinkedStatus> linkedStatuses = new ArrayList<>();
        LinkedStatus previous;

        linkedStatuses.add(previous = LinkedStatus.determine());
        while (linkedStatuses.size() < playersCount) {
            linkedStatuses.add(previous = LinkedStatus.determine(previous));
        }

        return new HorizonLine(linkedStatuses);
    }

    public GameResult goDown(Players players, Rewards rewards) {
        HorizonLineResult horizonLineResult = new HorizonLineResult(playersCount);

        for (HorizonLine horizonLine : horizonLines) {
            horizonLine.goDown(horizonLineResult);
        }

        Map<Player, Reward> results = horizonLineResult.link(players, rewards);
        return new GameResult(results);
    }
}
