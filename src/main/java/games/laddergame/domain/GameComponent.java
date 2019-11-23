package games.laddergame.domain;

public interface GameComponent {
    String getName();

    int getPosition();

    boolean canParticipate(int participantPosition);

    void swapWith(GameComponent rightParticipant);

    void finalizeSwap(int temporary);
}
