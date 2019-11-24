package laddergame.view;

import laddergame.domain.LadderGame;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    private static final String EXCEPTION_INFO_MESSAGE = "ERROR : ";
    private static final String PLAYER_NAME_DELIMITER = " ";

    @Override
    public void showExceptionMessage(final Exception e) {
        System.out.println(EXCEPTION_INFO_MESSAGE + e.getMessage());
    }

    @Override
    public void showLadderGame(final LadderGame ladderGame) {
        List<String> alignedPlayerNames = ladderGame.getAlignedPlayerNames();
        System.out.println(StringUtils.join(alignedPlayerNames, PLAYER_NAME_DELIMITER));
    }
}
