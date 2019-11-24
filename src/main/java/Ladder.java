import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int height;
    private final int lineSize;
    private List<Lines> ladder = new ArrayList<>();

    public Ladder(int height, int lineSize, LineCreateStrategy strategy) {
        this.height = height;
        this.lineSize = lineSize;
        initialize(height, lineSize, strategy);
    }

    private void initialize(int height, int lineSize, LineCreateStrategy strategy) {
        for (int i = 0; i < height; i++) {
            ladder.add(new Lines(lineSize, strategy));
        }
    }

    public int run(int start) {
        int result = start;
        for (int i = 0; i < height; i++) {
            result = ladder.get(i).move(result);
        }

        return result;
    }
}
