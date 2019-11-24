package laddergame.domain.ladderplayer;

import laddergame.domain.name.LadderPlayerName;

import java.util.Objects;

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

    public String getAlignedName() {
        return ladderPlayerName.getAlignedName();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LadderPlayer that = (LadderPlayer) o;
        return Objects.equals(ladderPlayerName, that.ladderPlayerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderPlayerName);
    }
}
