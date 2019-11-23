package laddergame.exception;

import laddergame.domain.LadderHeight;

public class LackOfHeightException extends IllegalArgumentException {

    public static final String LACK_OF_HEIGHT_MESSAGE = "높이는 " + LadderHeight.MIN_HEIGHT + " 이상의 수입니다.";

    public LackOfHeightException() {
        super(LACK_OF_HEIGHT_MESSAGE);
    }
}
