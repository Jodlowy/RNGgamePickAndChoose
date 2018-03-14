package data.prizes;

import data.Player;

public class GameOver extends Prize {

    public GameOver() {
        super(PrizeType.OVER, 0);
    }

    public void specialEffect(Player player) {
        player.takeLife();
    }

}
