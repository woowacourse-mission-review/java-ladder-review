package games.library;

import games.laddergame.domain.GameComponent;

@FunctionalInterface
public interface ObjectMakingStrategy {
    GameComponent makeObject(String name, int position);
}
