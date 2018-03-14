package data.pools;

import java.util.List;

public class PoolSettings {

    private List<Integer> prizeScheme;

    private int extraLifeCount;

    private int gameOverCount;


    public PoolSettings(List<Integer> prizeScheme, int extraLifeCount,
                        int gameOverCount) {
        this.prizeScheme = prizeScheme;
        this.extraLifeCount = extraLifeCount;
        this.gameOverCount = gameOverCount;
    }


    public List<Integer> getPrizeScheme() {
        return prizeScheme;
    }

    public int getExtraLifeCount() {
        return extraLifeCount;
    }

    public int getGameOverCount() {
        return gameOverCount;
    }

}
