package laddergame.view;

import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.Lines;
import laddergame.domain.ladder.Point;
import laddergame.domain.ladder.Results;
import laddergame.domain.user.Position;
import laddergame.domain.user.User;
import laddergame.domain.user.Users;
import org.apache.commons.lang3.StringUtils;

public class OutputView {

    private static final int MAX_LEN_OF_USER_NAME = 5;
    private static final String USER_RESULT_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";

    public static void printLadder(Users users, Lines lines, Results results) {
        printUsers(users);
        for (Line line : lines.getLines()) {
            printLine(line);
        }
        printResults(users.getSize(), results);
    }

    private static void printResults(final int numOfUsers, final Results results) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numOfUsers; i++) {
            stringBuilder.append(StringUtils.leftPad(results.getResultOf(Position.of(i)), MAX_LEN_OF_USER_NAME + 1));
        }

        System.out.println(stringBuilder.toString());
    }

    private static void printUsers(final Users users) {
        StringBuilder stringBuilder = new StringBuilder();

        for (User user : users.getUsers()) {
            stringBuilder.append(StringUtils.leftPad(user.getName(), MAX_LEN_OF_USER_NAME + 1));
        }
        System.out.println(stringBuilder.toString());
    }

    private static void printLine(final Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Point point : line.getPoints()) {
            stringBuilder.append(point.isFirst() ? "     |" : "|")
                .append(point.canMoveRight() ? "-----" : "     ");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printResultOf(final String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public static void printAllResult(final Users users, final Results results) {
        StringBuilder stringBuilder = new StringBuilder();
        users.getUsers().forEach(user ->
            stringBuilder.append(user.getName())
                .append(USER_RESULT_DELIMITER)
                .append(results.getResultOf(user.getPosition()))
                .append(NEW_LINE)
        );
        System.out.println(stringBuilder.toString());
    }
}
