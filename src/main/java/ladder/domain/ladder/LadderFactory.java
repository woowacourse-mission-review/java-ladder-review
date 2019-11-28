package ladder.domain.ladder;

public interface LadderFactory {
    Ladder create(final Height height, final int countOfPlayers);
}
