package domain;

public enum LinkedStatus {
    LINKED, UNLINKED;

    private static final Double THRESHOLD = 0.5;

    public static LinkedStatus determine(final LinkedStatus status) {
        if (status.equals(LINKED)) {
            return UNLINKED;
        }
        return determine();
    }

    public static LinkedStatus determine() {
        if (Math.random() < THRESHOLD) {
            return UNLINKED;
        }
        return LINKED;
    }
}
