package view;

import domain.*;

public class ConsoleOutputView {
    private static final int MAX_STRING_SIZE = 5;
    private static final String EMPTY = "";

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
            if (line.isDrawn()) {
                System.out.print(LINE);
            } else {
                System.out.print(EMPTY_LINE);
            }
            System.out.print(COLUMN);
        }
    }

    private void drawNames() {
        for (Name name : names.getNames()) {
            int nameLength = name.length();

            drawEmpty(getFrontEmptySize(nameLength));
            System.out.print(name.getName());
            drawEmpty(getBehindEmptySize(nameLength));
        }
        System.out.println();
    }

    private void drawResults() {
        for (Result result : results.getResults()) {
            int resultLength = result.length();

            drawEmpty(getFrontEmptySize(resultLength));
            System.out.print(result.getResult());
            drawEmpty(getBehindEmptySize(resultLength));
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
            System.out.print(EMPTY);
        }
    }
}
