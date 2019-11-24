import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int START_INDEX = 0;
    
    private final int height;
    private final int lineSize;
    private List<Lines> ladder = new ArrayList<>();

    public Ladder(int height, int lineSize, LineCreateStrategy strategy) {
        this.height = height;
        this.lineSize = lineSize;
        initialize(height, lineSize, strategy);
    }

    private void initialize(int height, int lineSize, LineCreateStrategy strategy) {
        for (int index = START_INDEX; index < height; index++) {
            ladder.add(new Lines(lineSize, strategy));
        }
    }

    public int run(int startLineIndex) {
        int resultLineIndex = startLineIndex;
        for (int index = START_INDEX; index < height; index++) {
            resultLineIndex = ladder.get(index).move(resultLineIndex);
        }

        return resultLineIndex;
    }
}
