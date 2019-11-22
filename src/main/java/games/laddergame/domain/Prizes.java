package games.laddergame.domain;

import java.util.List;

public class Prizes {
    private List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public boolean isNotSuccessfullyMade() {
        return prizes == null;
    }
}
