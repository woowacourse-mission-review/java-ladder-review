package games.racinggame.domain.instructions;

public class SimpleMovementInstruction implements MovementInstruction {
    @Override
    public int provideInstructionForCars() {
        return 1;
    }
}
