package laddergame.domain.player;

public class LadderPlayer {

    private final LadderPlayerName ladderPlayerName;

    private LadderPlayer(final String name) {
        this.ladderPlayerName = new LadderPlayerName(name);
    }

    public static LadderPlayer from(String name) {
        return new LadderPlayer(name);
    }

    public boolean matchName(final String name) {
        return ladderPlayerName.matchName(name);
    }

    public String getName() {
        return ladderPlayerName.getName();
    }
}
