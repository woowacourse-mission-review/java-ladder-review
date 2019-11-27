package ghostleg.domain;

import org.apache.commons.lang3.StringUtils;

public class Reward {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 10;

    private final String name;

    public Reward(String name) {
        name = StringUtils.trim(name);
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("보상의 이름은 %d 자 이상 %d 자 이하여야 합니다.", MIN_LENGTH, MAX_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}
