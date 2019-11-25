package laddergame.service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class LadderGameReservedKeywords {

    public static final String KEYWORD_FOR_ALL_RESULTS = "all";
    public static final String KEYWORD_FOR_EXITING_GAME = "exit";

    private LadderGameReservedKeywords() {
    }

    public static List<String> getAllKeywords() {
        try {
            List<String> allKeywords = new ArrayList<>();
            LadderGameReservedKeywords instance = new LadderGameReservedKeywords();

            for (Field field : LadderGameReservedKeywords.class.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (isStaticAndFinal(modifiers)) {
                    String value = (String) field.get(instance);
                    allKeywords.add(value);
                }
            }
            return allKeywords;
        } catch (IllegalAccessException e) {
            throw new gettingAllKeywordsFailedException();
        }
    }

    private static boolean isStaticAndFinal(final int modifiers) {
        return Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
    }
}
