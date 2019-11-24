package laddergame.view;

public enum InputMessage {
    INPUT_NAME("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    INPUT_RESULT("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
