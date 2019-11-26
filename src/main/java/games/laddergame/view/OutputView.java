package games.laddergame.view;

import games.laddergame.domain.GameComponent;
import games.laddergame.domain.GameResult;
import games.laddergame.domain.ladder.MeetingBridge;
import games.laddergame.domain.ladder.Row;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printGameResult(GameResult gameResult) {
        System.out.println("사다리 결과입니다!");
        printEachName(gameResult.getPlayers());
        printLadder(gameResult.getLadder());
        printEachName(gameResult.getPrizes());
    }

    private void printLadder(List<Row> ladder) {
        ladder.forEach(row -> {
            printEachMatchingPoint(row);
            System.out.println();
        });
    }

    private void printEachMatchingPoint(Row row) {
        List<MeetingBridge> meetingBridges = row.getMeetingBridges();
        System.out.print("     |");
        meetingBridges.forEach(meetingPoint -> {
            if (meetingPoint.isSwap()) {
                System.out.print("-----");
            } else {
                System.out.print("     ");
            }
            System.out.print("|");
        });
    }

    private void printEachName(List<GameComponent> players) {
        StringBuilder stringBuilder = new StringBuilder();

        players.forEach(player -> stringBuilder.append(String.format("%6s", player.getName())));
        stringBuilder.append("\n");
        System.out.println(stringBuilder.toString());
    }

    public void printUserInquiry(String userInput, Map<String, String> organizedResults) {
        System.out.println(organizedResults.get(userInput));
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
