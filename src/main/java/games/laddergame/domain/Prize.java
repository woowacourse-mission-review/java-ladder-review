package games.laddergame.domain;

public class Prize implements GameComponent {
    private String name;
    private int position;
    public Prize(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
