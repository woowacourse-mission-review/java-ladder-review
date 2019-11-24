package domain;

import java.util.Iterator;
import java.util.List;

public class HorizonLine implements Iterable<LinkedStatus> {
    private final List<LinkedStatus> linkedStatus;

    public HorizonLine(final List<LinkedStatus> linkedStatus) {
        this.linkedStatus = linkedStatus;
    }

    public void goDown(final HorizonLineResult horizonLineResult) {
        for (int i = 1; i <= linkedStatus.size(); i++) {
            if (linkedStatus.get(i - 1).equals(LinkedStatus.LINKED)) {
                horizonLineResult.swap(i - 1, i);
            }
        }
    }

    @Override
    public Iterator<LinkedStatus> iterator() {
        return linkedStatus.iterator();
    }
}
