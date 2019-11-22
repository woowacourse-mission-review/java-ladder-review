package games.laddergame.domain;

import games.laddergame.exception.DuplicateNameException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameComponents {
    private List<GameComponent> gameComponents;
    private static int STARTING_POSITION = 0;

    public GameComponents(List<GameComponent> gameComponents) {
        try {
//            checkDuplicateNames(gameComponents);
            this.gameComponents = gameComponents;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.gameComponents = null;
        }
    }

    private void checkDuplicateNames(List<GameComponent> gameComponents) {
        List<String> componentNames = gameComponents.stream()
                .map(component -> component.getName())
                .collect(Collectors.toList());

        Set<String> uniqueComponentNAmes = new HashSet<>(componentNames);

        if (uniqueComponentNAmes.size() != componentNames.size()) {
            throw new DuplicateNameException();
        }
    }

    public boolean isNotSuccessfullyMade() {
        return gameComponents == null;
    }

    public GameComponent getComponentAt(int index) {
        return gameComponents.get(index);
    }
}
