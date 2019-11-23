package ladder.domain;

public interface LadderFactory {
    Ladder create(final Height height, final int countOfPlayers);
}
