package gameplay;

import data.pools.GamePool;
import data.Player;
import data.pools.Pools;
import gameservice.GameHost;
import gameservice.InputHandler;

public class TheGame {
    public static void main(String[] args) {
        GameController controller = new GameController();
        GamePool basePool = controller.gamePoolsSetup(Pools.mainPoolSettings);
        GamePool extraPool = controller.gamePoolsSetup(Pools.extraPoolSettings);
        extraPool.addSecondChance(1);
        controller.shufflePools(basePool, extraPool);
        InputHandler input = new InputHandler();
        GameHost host = new GameHost();
        host.welcome();
        Player player = new Player(input.getPlayerName());
        controller.play(player, basePool, extraPool, host, input);
    }
}