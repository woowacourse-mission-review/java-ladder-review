package domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HorizonLines implements Iterable<HorizonLine> {
    private final List<HorizonLine> horizonLines;

    HorizonLines(final List<HorizonLine> horizonLines) {
        this.horizonLines = Collections.unmodifiableList(horizonLines);
    }

    @Override
    public Iterator<HorizonLine> iterator() {
        return horizonLines.iterator();
    }
}
