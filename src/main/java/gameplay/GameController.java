package gameplay;

import data.Player;
import data.pools.PoolSettings;
import data.prizes.Prize;
import data.pools.GamePool;
import gameservice.GameHost;
import gameservice.InputHandler;

public class GameController {

    public GamePool gamePoolsSetup(PoolSettings poolSettings) {
        return new GamePool(poolSettings);
    }

    public void showThePool(GamePool gamePool) {
        gamePool.displayAvailableBoxes();
    }

    public Prize getPrize(GamePool gamePool, InputHandler input) {
        return gamePool.getTheReward(gamePool.pickABox(
                gamePool.getPool(), input));
    }

    public void useSecondChance(GamePool gamePool, Player player, Prize extraPrize) {
        extraPrize.specialEffect(player);
        gamePool.updatePool(gamePool.getPool().indexOf(extraPrize));
    }

    public void shufflePools(GamePool basePool, GamePool extraPool) {
        basePool.shufflePool();
        extraPool.shufflePool();
    }

    public void play(Player player, GamePool basePool, GamePool extraPool,
                     GameHost host, InputHandler input) {
        while (player.isAlive()) {
            showThePool(basePool);
            Prize prize = getPrize(basePool, input);
            prize.specialEffect(player);
            host.informAboutTheRewards(prize, player);
            if (prize.getPrizeType().getDescription().equals("Game Over")) {
                if (player.isAlive()) {
                    host.noWorriesExtraLife();
                } else {
                    host.readyForMore(player);
                    showThePool(extraPool);
                    Prize extraPrize = getPrize(extraPool, input);
                    if (extraPrize.getPrizeType().getDescription()
                            .equals("Second Chance")) {
                        useSecondChance(extraPool, player, extraPrize);
                        host.informAboutTheRewards(extraPrize, player);
                    } else {
                        host.informAboutTheRewards(extraPrize, player);
                        extraPrize.specialEffect(player);
                        host.announceGameOver(player);
                    }
                }
            }
            basePool.updatePool(basePool.getPool().indexOf(prize));
        }
        host.showTheResult(player.getName(), player.getPlayersFinalAward());
    }

}
