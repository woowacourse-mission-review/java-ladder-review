package laddergame.exception;

public class ReservedKeywordException extends IllegalArgumentException {

    public ReservedKeywordException(final String s) {
        super("'" + s + "' 은(는) 예약어이므로 사용자 이름으로 사용하실 수 없습니다.");
    }
}
