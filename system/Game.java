package system;

import moves.CpuMove;
import moves.UserMove;

import static system.Board.counter;
import static system.Side.O;
import static system.Side.X;
import static setup.Players.gracz1;
import static setup.Players.gracz2;
import static setup.Players.setPlayers;

public class Game {
    public static void main(String[] args) {

        //przygotowanie
        Board board = new Board();
        setPlayers();

       //gra
        do {
            //tura X
            System.out.println(counter + 1 + ". Ruch gracza X");
            if (gracz1.equals("c")) {
                CpuMove cpuMove = new CpuMove();
                cpuMove.cpuMove(board, X);
            } else {
                UserMove userMove = new UserMove();
                userMove.userMove(board, X);
            }

            // chciałem wrzucić poniższe rzędy 33-42 w odrębną klasę, ale wyrzucała błąd - break poza pętlą
            board.print();
            if (board.isWin(X)) {
                System.out.println("Koniec gry, gracz X wygrywa!");
                break;
            }

            if (counter == 9) {
                System.out.println("Koniec gry, remis!");
                break;
            }

            //tura O
            System.out.println(counter + 1 + ". Ruch gracza O");
            if (gracz2.equals("c")) {
                CpuMove cpuMove = new CpuMove();
                cpuMove.cpuMove(board, O);
            } else {
                UserMove userMove = new UserMove();
                userMove.userMove(board, O);
            }
            //sprawdzenie j.w.
            board.print();
            if (board.isWin(O)) {
                System.out.println("Koniec gry, gracz O wygrywa!");
                break;
            }

            if (counter == 9) {
                System.out.println("Koniec gry, remis!");
                break;
            }
        }
        while (true);
    }
}



