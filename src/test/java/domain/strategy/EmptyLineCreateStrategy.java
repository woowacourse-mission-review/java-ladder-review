package domain.strategy;

public class EmptyLineCreateStrategy implements LineCreateStrategy {

    @Override
    public boolean create() {
        return false;
    }
}
