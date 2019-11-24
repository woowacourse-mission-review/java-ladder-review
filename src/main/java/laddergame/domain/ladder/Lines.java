package laddergame.domain.ladder;

import java.util.List;

public class Lines {

    public static final String NEW_LINE = "\n";
    private final List<Line> lines;

    public Lines(final List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lines.forEach(stringBuilder::append);
        return stringBuilder.append(NEW_LINE).toString();
    }
}
