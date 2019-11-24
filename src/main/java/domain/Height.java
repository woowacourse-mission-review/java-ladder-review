package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Height {
    private static final Pattern pattern = Pattern.compile("^[1-9]+[0-9]*$");

    private final int height;

    public Height(final String heightInput) {
        validate(heightInput);
        height = Integer.parseInt(heightInput);
    }

    private void validate(final String heightInput) {
        Matcher matcher = pattern.matcher(heightInput);
        if (!matcher.find()) {
            throw new IllegalArgumentException("1 이상 정수를 입력해주세요.");
        }
    }

    public int getHeight() {
        return height;
    }
}
