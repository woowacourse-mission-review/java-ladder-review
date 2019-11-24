package support;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {
    private static final String DELIMITER = ",";

    public static List<String> parse(String input) {
        return Stream.of(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
