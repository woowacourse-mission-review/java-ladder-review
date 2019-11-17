package domain;

public class SimpleMovementInstruction implements MovementInstruction {
    @Override
    public int provideInstructionForCars() {
        return 1;
    }
}
