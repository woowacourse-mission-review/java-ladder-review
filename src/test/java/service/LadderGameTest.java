package service;

import domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {
    private LadderGame ladderGame = new LadderGame();

    @Test
    @DisplayName("참가자 등록")
    void register_players() {
        String playersInput = "pobi, honux, crong, jk";
        Players players = ladderGame.registerPlayers(playersInput);

        Assertions.assertEquals(players.get(0), new Player("pobi"));
        assertEquals(players.get(1), new Player("honux"));
        assertEquals(players.get(2), new Player("crong"));
        assertEquals(players.get(3), new Player("jk"));
    }

    @Test
    @DisplayName("높이 등록")
    void register_height() {
        String heightInput = "5";
        Height height = ladderGame.registerHeight(heightInput);

        assertEquals(height, new Height(heightInput));
    }

    @Test
    @DisplayName("보상 등록")
    void register_rewards() {
        String rewardsInput = "o,x,o,x";
        ladderGame.registerPlayers("pobi, honux, crong, jk");
        Rewards rewards = ladderGame.registerRewards(rewardsInput);

        Assertions.assertEquals(rewards.get(0), new Reward("o"));
        assertEquals(rewards.get(1), new Reward("x"));
        assertEquals(rewards.get(2), new Reward("o"));
        assertEquals(rewards.get(3), new Reward("x"));
    }
}
