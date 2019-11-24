import java.util.Random;

public class RandomLineCreateStrategy implements LineCreateStrategy {
    private Random random = new Random();

    @Override
    public boolean create() {
        return random.nextBoolean();
    }
}
