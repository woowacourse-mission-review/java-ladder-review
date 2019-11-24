public class Line {
    private final int index;
    private boolean hasLine;

    public Line(final int index) {
        this.index = index;
    }

    public void initialize(boolean leftLine, boolean rightLine, LineCreateStrategy strategy) {
        if (leftLine || rightLine) {
            hasLine = false;
        }

        hasLine = strategy.create();
    }

    public boolean getLine() {
        return hasLine;
    }
}
