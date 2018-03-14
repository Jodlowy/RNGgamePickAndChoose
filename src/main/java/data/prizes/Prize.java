package data.prizes;

import data.Player;

public abstract class Prize {
    protected PrizeType prizeType;
    protected int prizeAmount;

    public Prize(PrizeType prize, int prizeAmount) {
        this.prizeType = prize;
        this.prizeAmount = prizeAmount;
    }

    public PrizeType getPrizeType() {
        return prizeType;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public abstract void specialEffect(Player player);

}