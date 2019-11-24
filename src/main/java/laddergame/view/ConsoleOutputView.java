package laddergame.view;

public class ConsoleOutputView implements OutputView {

    private static final String EXCEPTION_INFO_MESSAGE = "ERROR : ";

    @Override
    public void showExceptionMessage(final Exception e) {
        System.out.println(EXCEPTION_INFO_MESSAGE + e.getMessage());
    }
}
