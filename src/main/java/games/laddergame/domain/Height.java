package games.laddergame.domain;

import static games.utility.BaseGameValidityChecker.checkValidQuantity;

public class Height {
    private static final int WRONG_ROUNDS = 0;
    private int height;

    public Height(String rawHeight) {
        try {
            int height = Integer.parseInt(rawHeight);
            checkValidQuantity(height);
            this.height = height;
        } catch (Exception e) {
            System.out.println("사디리 높이는 0이상의 정수만 허용합니다!");
            this.height = WRONG_ROUNDS;
        }
    }

    public int getHeight() {
        return height;
    }

    public boolean isNotSuccessfullyMade() {
        return height == WRONG_ROUNDS;
    }
}
