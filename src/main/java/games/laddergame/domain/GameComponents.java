package games.laddergame.domain;

import games.laddergame.exception.DuplicateNameException;

import java.util.*;
import java.util.stream.Collectors;

public class GameComponents {
    private List<GameComponent> gameComponents;

    public GameComponents(List<GameComponent> gameComponents, boolean isDuplicateCheckNecessary) {
        try {
            checkIfGameComponentsProperlyMade(gameComponents);
            checkDuplicates(gameComponents, isDuplicateCheckNecessary);
            this.gameComponents = gameComponents;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.gameComponents = null;
        }
    }

    private void checkIfGameComponentsProperlyMade(List<GameComponent> gameComponents) {
        if (gameComponents == null) {
            throw new IllegalArgumentException("이름이 제대로 생성되지 않았습니다.");
        }
    }

    private void checkDuplicates(List<GameComponent> gameComponents, boolean isDuplicateCheckNecessary) {
        if (isDuplicateCheckNecessary) {
            checkDuplicateNames(gameComponents);
        }
    }

    private void checkDuplicateNames(List<GameComponent> gameComponents) {
        List<String> componentNames = gameComponents.stream()
                .map(GameComponent::getName)
                .collect(Collectors.toList());

        Set<String> uniqueComponentNames = new HashSet<>(componentNames);

        if (uniqueComponentNames.size() != componentNames.size()) {
            throw new DuplicateNameException();
        }
    }

    public boolean isNotSuccessfullyMade() {
        return gameComponents == null;
    }

    public GameComponent getComponentAt(int index) {
        return gameComponents.get(index);
    }

    public int size() {
        return gameComponents.size();
    }

    public List<GameComponent> collectParticipants(int position) {
        List<GameComponent> participants = new ArrayList<>();

        int leftParticipantPosition = position - 1;
        int rightParticipantPosition = position;

        participants.add(findParticipant(leftParticipantPosition));
        participants.add(findParticipant(rightParticipantPosition));

        return participants;
    }

    private GameComponent findParticipant(int participantPosition) {
        return gameComponents.stream()
                .filter(gameComponent -> gameComponent.canParticipate(participantPosition))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<GameComponent> getComponents() {
        return Collections.unmodifiableList(gameComponents);
    }
}
