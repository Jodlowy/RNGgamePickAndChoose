package gameservice;

import data.Player;
import data.prizes.Prize;

public class GameHost {

    public void welcome() {
        System.out.println("Welcome to the game stranger!");
    }

    public void showTheResult(String playerName, int result) {
        if (result > 0) {
            System.out.println(
                    "Congratulations! " + playerName + ", you won " + result + "euros!"
            );
        } else {
            System.out.println(playerName + ", well... what goes around comes around...");
        }
    }

    public void readyForMore(Player player) {
        System.out.println(player.getName() + ", ready for more? Pick one of these: ");
    }

    public void announceGameOver(Player player) {
        System.out.println("Here, " + player.getName() + " the game ends..!");
    }

    public void informAboutTheRewards(Prize prize, Player player) {
        switch (prize.getPrizeType().getDescription()) {
            case "Standard Prize":
                System.out.println(
                        "You're winning... " + prize.getPrizeType().getDescription()
                                + " of " + prize.getPrizeAmount() + " euros!");
                break;
            case "Extra Life":
                System.out.println(
                        "You're winning... "
                                + prize.getPrizeType().getDescription() + "!");
                break;
            case "Second Chance":
                System.out.println(player.getName()
                        + " I'll give you one more chance...");
                break;
        }
    }

    public void noWorriesExtraLife() {
        System.out.println(
                "This would be Game Over, but no worries you have an Extra life !");
    }

    public void askForName() {
        System.out.print("Would you mind telling me your name?");
    }

    public void askForBox() {
        System.out.print("Select the box u want to uncover: ");
    }

    public void sayAvailableOnly() {
        System.out.println("Please select one of the available boxes");
    }

    public void sayNumOnly() {
        System.out.print("Please enter numerical values only: ");
    }

    public void notHearYou() {
        System.out.println("I'm afraid I couldn't hear you...");
    }

    public void letsPlay(String name) {
        System.out.println(name + ", let's play a Game!");
    }

    public void diffLanguages() {
        System.out.print("I'm afraid we speak different languages :(... ");
    }
}
