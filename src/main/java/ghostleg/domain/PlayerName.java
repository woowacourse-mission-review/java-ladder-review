package ghostleg.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

public class PlayerName {
    private static final String NAME_PATTERN = "[a-zA-Z][\\sa-zA-Z]*";
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;
    private final String name;

    public PlayerName(String name) {
        name = StringUtils.trim(name);
        validateLength(name);
        validateOnlyEnglishAndSpaceBar(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("플레이어 이름은 %d 자 이상 %d 자 이하여야 합니다.", MIN_LENGTH, MAX_LENGTH));
        }
    }

    private void validateOnlyEnglishAndSpaceBar(String name) {
        if (!Pattern.matches(NAME_PATTERN, name)) {
            throw new IllegalArgumentException("플레이어 이름은 영문자와 스페이스 바 만 들어갈 수 있습니다.");
        }
    }

    public String getValue() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
