package games.library;

import games.laddergame.domain.GameComponent;
import games.utility.CommaParser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ObjectMakingTemplate<T> {
    public static ObjectMakingTemplate getInstance() {
        return LazyHolder.INSTANCE;
    }

    public List<GameComponent> createObjects(String rawData, ObjectMakingStrategy logic) {
        List<String> parsedData = CommaParser.parse(rawData);
        int max = parsedData.size() - 1;

        return IntStream.rangeClosed(0, max)
                .mapToObj(index -> logic.makeObject(parsedData.get(index), index))
                .collect(Collectors.toList());
    }

    private static class LazyHolder {
        private static ObjectMakingTemplate INSTANCE = new ObjectMakingTemplate();
    }
}
