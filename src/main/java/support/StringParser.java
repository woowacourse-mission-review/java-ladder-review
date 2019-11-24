package support;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {
    private static final String DELIMITER = ",";

    private static boolean isDuplicated(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        return names.size() != uniqueNames.size();
    }

    public static List<String> parse(String input) {
        return Stream.of(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
