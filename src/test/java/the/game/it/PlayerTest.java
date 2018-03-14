package the.game.it;

import data.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class PlayerTest {

    private final Player player = new Player("Test");

    @Test
    public void new_plaer_name_is_equal_to_given() {
        Player player = new Player("Test Name");
        assertThat(player.getName().equals("Test Name")).isTrue();
    }

    @Test
    public void new_player_has_no_rewards() {
        assertThat(player.getPlayersFinalAward()).isEqualTo(0);
    }

    @Test
    public void new_player_isAlive() {
        assertThat(player.isAlive()).isTrue();
    }

    @Test
    public void new_player_secondChance_available() {
        assertThat(player.isSecondChanceAvailable()).isTrue();
    }

    @Test
    public void setPlayersFinalReward_adds_reward() {
        player.setPlayersFinalAward(10);
        assertThat(player.getPlayersFinalAward()).isEqualTo(10);

        player.setPlayersFinalAward(20);
        assertThat(player.getPlayersFinalAward()).isEqualTo(30);
    }

    @Test
    public void takeLife_takes_life() {
        player.takeLife();
        assertThat(player.isAlive()).isFalse();
    }

    @Test
    public void addExtraLife_adds_life() {
        player.addExtraLife();
        player.takeLife();
        assertThat(player.isAlive()).isTrue();
    }

    @Test
    public void setSecondChanceAvailable_adds_Extra_Life() {
        player.takeLife();
        player.setSecondChanceAvailable(false);
        assertThat(player.isAlive()).isTrue();
    }

}
