package games.laddergame.domain;

public class Prize {
    private String name;
    private int position;
    public Prize(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
