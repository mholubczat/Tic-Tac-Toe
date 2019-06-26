package setup;

import java.util.Scanner;

public class Players {
    public static String gracz1;
    public static String gracz2;

    public static void setPlayers() {
        // ustawienia graczy

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz gracza X");
        do {
            System.out.println("Człowiek - wprowadź h, komputer - wprowadź c");
            gracz1 = scanner.next();
        }
        while (!(gracz1.equals("h") || gracz1.equals("c")));

        System.out.println("Wybierz gracza O");
        do {
            System.out.println("Człowiek - wprowadź h, komputer - wprowadź c");
            gracz2 = scanner.next();

        }
        while (!(gracz2.equals("h") || gracz2.equals("c")));
    }

}

