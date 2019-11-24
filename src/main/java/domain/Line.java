package domain;

import domain.strategy.LineCreateStrategy;

public class Line {
    private boolean hasLine;

    public void initialize(boolean hasLeftLine, LineCreateStrategy strategy) {
        if (hasLeftLine) {
            hasLine = false;
            return;
        }

        hasLine = strategy.create();
    }

    public boolean isDrawn() {
        return hasLine;
    }
}
