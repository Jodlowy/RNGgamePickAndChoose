package data.prizes;

import data.Player;

public class SecondChance extends Prize {

    public SecondChance() {
        super(PrizeType.CHANCE, 0);
    }

    public void specialEffect(Player player) {
        player.setSecondChanceAvailable(false);
    }
}
