package games.laddergame.domain.ladder;

import games.laddergame.domain.GameComponents;

import java.util.List;
import java.util.Objects;

public class Row {
    private List<MeetingPoint> row;

    public Row(List<MeetingPoint> row) {
        this.row = row;
    }

    public void playCurrentRow(GameComponents players) {
        row.forEach(meetingPoint -> meetingPoint.swap(players));
    }

    public int size() {
        return row.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row1 = (Row) o;
        return Objects.equals(row, row1.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row);
    }
}
