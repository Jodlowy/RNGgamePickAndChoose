package gameplay;

import data.pools.GamePool;
import data.Player;
import data.pools.Pools;
import data.prizes.Prize;

import java.util.Random;

public class GameSymulator {

    public int playTheGameUsingAI() {
        GameController controller = new GameController();
        GamePool basePool = controller.gamePoolsSetup(Pools.mainPoolSettings);
        GamePool extraPool = controller.gamePoolsSetup(Pools.extraPoolSettings);
        extraPool.addSecondChance(1);
        controller.shufflePools(basePool, extraPool);
        Player player = new Player("HAL 9000");

        while (player.isAlive()) {
            Prize prize = basePool.getPool().get(
                    boxSelector(basePool.getPool().size()));
            prize.specialEffect(player);
            if (prize.getPrizeType().getDescription().equals("Game Over")) {
                if (!player.isAlive()) {
                    Prize extraPrize = extraPool.getPool().get(
                            boxSelector(extraPool.getPool().size()));
                    if (extraPrize.getPrizeType().getDescription().
                            equals("Second Chance")) {
                        controller.useSecondChance(extraPool, player, extraPrize);
                    } else {
                        extraPrize.specialEffect(player);
                    }
                }
            }
            basePool.updatePool(basePool.getPool().indexOf(prize));
        }
        return player.getPlayersFinalAward();
    }

    private static int boxSelector(int max) {
        if (max == 1) {
            return 0;
        }
        Random r = new Random();
        return r.ints(1, (max)).findFirst().getAsInt();
    }

    public int getAverageForPlentyIterations() {
        int numOfIterations = 10_000_000;
        int sumOfArray = 0;

        for (int i = 0; i < numOfIterations; i++) {
            GameSymulator symulator = new GameSymulator();
            sumOfArray += symulator.playTheGameUsingAI();
        }

        return sumOfArray / numOfIterations;
    }
}


