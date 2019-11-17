public class MethodNotAllowedException extends RuntimeException {
    private static final String MESSAGE = "허용하지 않는 method입니다!";

    public MethodNotAllowedException() {
        super(MESSAGE);
    }
}
