package domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HorizonLine implements Iterable<LinkedStatus> {
    private final List<LinkedStatus> linkedStatus;

    public HorizonLine(final List<LinkedStatus> linkedStatus) {
        this.linkedStatus = Collections.unmodifiableList(linkedStatus);
    }

    public void goDown(final HorizonLineResult horizonLineResult) {
        for (int i = 1; i <= linkedStatus.size(); i++) {
            determineSwap(horizonLineResult, i);
        }
    }

    private void determineSwap(final HorizonLineResult horizonLineResult, final int i) {
        if (linkedStatus.get(i - 1).equals(LinkedStatus.LINKED)) {
            horizonLineResult.swap(i - 1, i);
        }
    }

    public List<LinkedStatus> getLinkedStatus() {
        return linkedStatus;
    }

    @Override
    public Iterator<LinkedStatus> iterator() {
        return linkedStatus.iterator();
    }
}
