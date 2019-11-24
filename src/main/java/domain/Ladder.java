package domain;

import java.util.ArrayList;
import java.util.List;

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
}
