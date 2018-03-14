package data.prizes;

public enum PrizeType {

    STANDARD("Standard Prize"),
    EXTRA("Extra Life"),
    CHANCE("Second Chance"),
    OVER("Game Over");

    private String description;

    PrizeType(String desc) {
        description = desc;
    }

    public String getDescription() {
        return description;
    }
}
