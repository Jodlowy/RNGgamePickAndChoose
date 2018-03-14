package gameservice;

import java.util.*;

public class InputHandler {
    Scanner scanner = new Scanner(System.in);
    GameHost host = new GameHost();

    public int enterBoxNumber(ArrayList boxes) {
        int length = boxes.size();
        boolean valid = true;
        int a = 0;
        do {
            try {
                if (valid) {
                    host.askForBox();
                }
                a = scanner.nextInt();
                if (a <= 0 || a > length) {
                    host.sayAvailableOnly();
                    a = 0;
                    valid = false;
                } else {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                host.sayNumOnly();
                valid = false;
            }
        } while (!valid);
        return a;
    }

    public String getPlayerName() {
        String name;
        do {
            try {
                host.askForName();
                name = scanner.nextLine().trim();
                if (name.equals("")) {
                    host.notHearYou();
                } else {
                    host.letsPlay(name);
                }
            } catch (IllegalArgumentException e) {
                host.diffLanguages();
                name = "";
            }
        } while (name.equals(""));

        return name;
    }
}
