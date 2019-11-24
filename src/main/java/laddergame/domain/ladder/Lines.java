package laddergame.domain.ladder;

import laddergame.domain.user.Users;

import java.util.List;

public class Lines {

    private static final String NEW_LINE = "\n";
    private final List<Line> lines;

    public Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public void moveUsers(final Users users) {
        lines.forEach(line -> line.moveUsers(users));
    }

    public List<Line> getLines() {
        return this.lines;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lines.forEach(stringBuilder::append);
        return stringBuilder.append(NEW_LINE).toString();
    }
}
