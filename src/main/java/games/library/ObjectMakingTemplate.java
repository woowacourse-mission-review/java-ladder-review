package games.library;

import games.utility.CommaParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ObjectMakingTemplate<T> {
    public static ObjectMakingTemplate getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static ObjectMakingTemplate INSTANCE = new ObjectMakingTemplate();
    }

    public List<T> createMultipleObjects(String rawData, ObjectMakingLogic<T> logic) {
        List<T> resultList = new ArrayList<>();
        List<String> parsedData = CommaParser.parse(rawData);
        int max = parsedData.size() - 1;

        return IntStream.rangeClosed(0, max)
                .mapToObj(index -> logic.makeObject(parsedData.get(index), index))
                .collect(Collectors.toList());
    }
}
