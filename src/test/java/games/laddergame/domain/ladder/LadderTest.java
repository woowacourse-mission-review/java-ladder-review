package games.laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리 생성 테스트")
    void construct_ladder() {
        MeetingPoint point1 = new MeetingPoint(1, true);
        MeetingPoint point2 = new MeetingPoint(2, false);
        MeetingPoint point3 = new MeetingPoint(3, true);
        Row row1 = new Row(Arrays.asList(point1, point2, point3));
        Row row2 = new Row(Arrays.asList(point1, point2, point3));
        Row row3 = new Row(Arrays.asList(point1, point2, point3));
        Row row4 = new Row(Arrays.asList(point1, point2, point3));

        List<Row> checkRows = Arrays.asList(row1, row2, row3, row4);


        Ladder ladder = new Ladder(3, 4, () -> new Row(Arrays.asList(point1, point2, point3)));

        assertThat(ladder.size()).isEqualTo(4);
        assertThat(ladder.getLadder()).isEqualTo(checkRows);
    }
}