package domain.instructions;

public class RandomMovementInstruction implements MovementInstruction {
    @Override
    public int provideInstructionForCars() {
        return (int) (Math.random() * 10);
    }
}
