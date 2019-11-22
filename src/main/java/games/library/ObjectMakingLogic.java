package games.library;

@FunctionalInterface
public interface ObjectMakingLogic<T> {
    T makeObject(String name, int position);
}
