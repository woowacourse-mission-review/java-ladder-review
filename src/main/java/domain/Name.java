package domain;

public class Name {
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("공백을 이름으로 입력할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
