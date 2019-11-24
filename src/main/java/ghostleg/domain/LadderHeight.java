package ghostleg.domain;

public class LadderHeight {
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 1000;

    private final int height;

    public LadderHeight(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 %d 이상 %d 이하여야 합니다.", MIN_HEIGHT, MAX_HEIGHT));
        }
    }

    public int getValue() {
        return height;
    }
}
