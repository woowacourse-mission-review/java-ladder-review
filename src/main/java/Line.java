public class Line {
    private boolean hasLine;

    public void initialize(boolean hasLeftLine, LineCreateStrategy strategy) {
        if (hasLeftLine) {
            hasLine = false;
            return;
        }

        hasLine = strategy.create();
    }

    public boolean getLine() {
        return hasLine;
    }
}
