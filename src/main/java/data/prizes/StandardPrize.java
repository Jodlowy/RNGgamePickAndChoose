package data.prizes;

import data.Player;

public class StandardPrize extends Prize {

    public StandardPrize(int prizeAmount) {
        super(PrizeType.STANDARD, prizeAmount);
    }

    public void specialEffect(Player player) {
        player.setPlayersFinalAward(getPrizeAmount());
    }
}
