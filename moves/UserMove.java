package moves;

import system.Board;
import system.Side;

import java.util.InputMismatchException;
import java.util.Scanner;

import static system.Side._;

public class UserMove {

    private int column;
    private int row;


    public void userMove(Board b, Side side) {

        boolean error;
        do {
            try {
                //nr wiersza
                do {
                    Scanner scanner = new Scanner(System.in);
                    error = false;
                    System.out.println("Podaj numer wiersza");
                    this.row = scanner.nextInt() - 1;
                } while (row < 0 || row > 2);
                //nr kolumny
                do {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Podaj numer kolumny");
                    this.column = scanner.nextInt() - 1;
                } while (row < 0 || row > 2);
            } catch (InputMismatchException ex) {
                error = true;
            }

            if (b.get(row, column) != _) {
                System.out.println("Pole zajęte!");
            }
                // powtórz aż do uzyskania pustego pola oraz w przypadku błędnego wprowadzenia

        } while (b.get(row, column) != _ || error);

        b.setBoard(row, column, side);
    }
}
