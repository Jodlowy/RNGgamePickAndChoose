package data.pools;

import data.prizes.*;
import gameservice.InputHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class GamePool {

    private ArrayList<Prize> pool;

    public GamePool(PoolSettings poolSettings) {
        ArrayList<Prize> pool = new ArrayList<>();

        pool.addAll(poolSettings.getPrizeScheme().stream()
                .map(i -> new StandardPrize(i))
                .collect(Collectors.toList()));
        for (int i = 0; i < poolSettings.getGameOverCount(); i++) {
            pool.add(new GameOver());
        }
        for (int i = 0; i < poolSettings.getExtraLifeCount(); i++) {
            pool.add(new ExtraLife());
        }
        setPool(pool);
    }

    public void setPool(ArrayList<Prize> pool) {
        this.pool = pool;
    }

    public ArrayList<Prize> getPool() {
        return this.pool;
    }

    public void addSecondChance(int secondChanceCount) {
        for (int i = 0; i < secondChanceCount; i++) {
            this.pool.add(new SecondChance());
        }
    }

    public void shufflePool() {
        long seed = System.nanoTime();
        Collections.shuffle(this.pool, new Random(seed));
    }

    public Prize getTheReward(int boxNumber) {
        return this.pool.get(boxNumber);
    }

    public int pickABox(ArrayList boxes, InputHandler input) {
        int boxIndex;
        //decrementing number for 0->n-1 numeration
        boxIndex = input.enterBoxNumber(boxes) - 1;
        return boxIndex;
    }

    public void displayAvailableBoxes() {
        for (Prize ele : pool) {
            //incrementing number for 0->n-1 numeration
            System.out.print((pool.indexOf(ele) + 1) + "  ");
        }
    }

    public void updatePool(int boxNumber) {
        this.pool.remove(boxNumber);
    }

}

