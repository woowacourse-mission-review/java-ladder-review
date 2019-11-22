package games.utility;

import games.racinggame.exception.InvalidCarNameException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseGameValidityChecker {
    private static final int GAME_BOUNDARY = 0;
    private static final int NAME_LOWERBOUNDARY = 1;
    private static final int NAME_UPPERBOUNDARY = 5;
    private static final String ALLOWED_PATTERNS = "^[a-zA-Z0-9]*$";

    public static boolean isNotValid(String name) {
        return checkAlphabetic(name) || checkNameLength(name);
    }

    private static boolean checkNameLength(String name) {
        return name.length() < NAME_LOWERBOUNDARY || name.length() > NAME_UPPERBOUNDARY;
    }

    private static boolean checkAlphabetic(String name) {
        return !name.matches(ALLOWED_PATTERNS);
    }

    public static void checkDuplicateCarNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() != carNames.size()) {
            throw new InvalidCarNameException();
        }
    }

    public static void checkValidRacingRounds(int racingRounds) {
        if (racingRounds <= GAME_BOUNDARY) {
            throw new IllegalArgumentException();
        }
    }
}
