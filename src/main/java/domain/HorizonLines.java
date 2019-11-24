package domain;

import java.util.Iterator;
import java.util.List;

public class HorizonLines implements Iterable<HorizonLine> {
    private final List<HorizonLine> horizonLines;

    HorizonLines(final List<HorizonLine> horizonLines) {
        this.horizonLines = horizonLines;
    }

    @Override
    public Iterator<HorizonLine> iterator() {
        return horizonLines.iterator();
    }
}
