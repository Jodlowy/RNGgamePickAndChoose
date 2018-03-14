package data;

public class Player {

    private String name;
    private boolean secondChanceAvailable = true;
    private int lifeCount = 1;
    private int playersFinalAward = 0;


    public void setSecondChanceAvailable(boolean chance) {
        secondChanceAvailable = chance;
        addExtraLife();
    }

    public boolean isSecondChanceAvailable() {
        return secondChanceAvailable;
    }

    public boolean isAlive() {
        return lifeCount > 0;
    }

    public void addExtraLife() {
        lifeCount++;
    }

    public void takeLife() {
        lifeCount--;
    }

    public String getName() {
        return name;
    }

    public Player(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayersFinalAward() {
        return playersFinalAward;
    }

    public void setPlayersFinalAward(int reward) {
        playersFinalAward += reward;
    }

}
