package data.prizes;

import data.Player;

public class ExtraLife extends Prize {

    public ExtraLife() {
        super(PrizeType.EXTRA, 0);
    }

    public void specialEffect(Player player) {
        player.addExtraLife();
    }

}
