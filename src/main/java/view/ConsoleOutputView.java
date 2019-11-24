package view;

import domain.*;

public class ConsoleOutputView {
    private static final int MAX_STRING_SIZE = 5;
    private static final String EMPTY_SPACE = " ";

    private static final String EMPTY_LINE = "     ";
    private static final String LINE = "-----";
    private static final String COLUMN = "|";


    private final Ladder ladder;
    private final Names names;
    private final Results results;

    public ConsoleOutputView(Ladder ladder, Names names, Results results) {
        this.ladder = ladder;
        this.names = names;
        this.results = results;
    }

    public void drawLadder() {
        System.out.println("사다리 결과");
        drawNames();

        for (Lines lines : ladder.getLadder()) {
            System.out.print("   " + COLUMN);
            drawLines(lines);
            System.out.println();
        }

        drawResults();
    }

    private void drawLines(Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print(line.isDrawn() ? LINE : EMPTY_LINE);
            System.out.print(COLUMN);
        }
    }

    private void drawNames() {
        for (Name name : names.getNames()) {
            int nameLength = name.length();
            int frontEmptySize = getFrontEmptySize(nameLength);
            int behindEmptySize = getBehindEmptySize(nameLength);

            drawEmpty(frontEmptySize);
            System.out.print(name.getName());
            drawEmpty(behindEmptySize);
        }
        System.out.println();
    }

    private void drawResults() {
        for (Result result : results.getResults()) {
            int resultLength = result.length();
            int frontEmptySize = getFrontEmptySize(resultLength);
            int behindEmptySize = getBehindEmptySize(resultLength);

            drawEmpty(frontEmptySize);
            System.out.print(result.getResult());
            drawEmpty(behindEmptySize);
        }
        System.out.println();
    }

    private int getFrontEmptySize(int length) {
        return (MAX_STRING_SIZE - length) / 2 + 1;
    }

    private int getBehindEmptySize(int length) {
        return (MAX_STRING_SIZE - length) / 2;
    }

    private void drawEmpty(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(EMPTY_SPACE);
        }
    }

    public void outputResult(String wantedResult) {
        System.out.println("실행 결과");
        if (wantedResult.equals("all")) {
            outputResultAll();
            return;
        }

        int startIndex = names.getIndex(new Name(wantedResult));
        int resultIndex = ladder.run(startIndex);
        System.out.println(wantedResult + ":" + results.get(resultIndex));
    }

    private void outputResultAll() {
        for (int startIndex = 0; startIndex < names.size(); ++startIndex) {
            int resultIndex = ladder.run(startIndex);
            System.out.println(names.get(startIndex) + " : " + results.get(resultIndex));
        }
    }
}
