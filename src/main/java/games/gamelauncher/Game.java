package games.gamelauncher;

public interface Game {
    boolean isPlayable(String gameName);

    void start();
}
