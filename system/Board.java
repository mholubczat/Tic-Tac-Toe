package system;


import static system.Side.*;

public class Board {
// licznik ruchów - po 9. remis
    public static int counter=0;
    Side[][] board = new Side[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = _;
            }
        }
    }
// wydruk planszy
    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void setBoard(int x, int y, Side move) {
        if (board[x][y] == _) {
            this.board[x][y] = move;
            counter++;
        }
    }
// warunek wygranej - rząd
    private boolean isWinRow(Side side) {

        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && board[0][i].equals(side)) {
                return true;
            }
        }
        return false;
    }
// warunek wygranej - kolumna
    private boolean isWinColumn(Side side) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && board[i][0].equals(side)) {
                return true;
            }
        }
        return false;
    }
    // warunek wygranej - przekątna
    public boolean isWinDiagonal(Side side) {
        return !(side == _) && (
                (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && board[0][0].equals(side))
                        || (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) && board[0][2].equals(side));
    }

    //suma warunków wygranej

    public boolean isWin(Side side) {
        return isWinColumn(side) || isWinDiagonal(side) || isWinRow(side);
    }


    /*Kluczowy rząd, zwraca wartości:
    1 2 3        nr zwycięskiego rzędu
    -1 -2 -3     nr rzędu do zablokowania
    0            brak kluczowych rzędów

    */
    public int keyRow(Side mySide) {
        int checker = 0;
        int result = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(X)) {
                    checker += 1;
                }
                if (board[i][j].equals(O)) {
                    checker += 10;
                }
            }
            // jeśli rząd jest 'zwycięski' - koniec pętli
            if ((checker == 2 && mySide.equals(X)) || (checker == 20 && mySide.equals(O))) {
                return i + 1;
            }
            // jeśli rząd do zablokowania - zapamiętaj który, szukaj dalej zwycięskiego rzędu
            if (checker == 2 || checker == 20) {
                result = i + 1;
            }
            checker = 0;

        }
        // brak zwycięskiego rzędu - zwróć rząd do zablokowania lub 0
        return -result;
    }

// kluczowe kolumny, analogicznie do rzędów
    public int keyCol(Side mySide) {
        int checker = 0;
        int result = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i].equals(X)) {
                    checker += 1;
                }
                if (board[j][i].equals(O)) {
                    checker += 10;
                }

            }
            if ((checker == 2 && mySide.equals(X)) || (checker == 20 && mySide.equals(O))) {
                return i + 1;
            }
            if (checker == 2 || checker == 20) {
                result = i + 1;
            }

            checker = 0;
        }
        return -result;
    }

    /* kluczowe przekątne, zwraca wartości:
    1           przkątna \ wygrywa
    -1          przekątna / wygrywa
    10          przekątna \ do zablokowania
    -10         przekątna / do zablokowania
    */

    public int keyDia(Side mySide) {
        int checker = 0;
        int revChecker = 0;
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][i].equals(X)) {
                checker += 1;
            }
            if (board[i][i].equals(O)) {
                checker += 10;
            }
            if (board[2 - i][i].equals(X)) {
                revChecker += 1;
            }
            if (board[2 - i][i].equals(O)) {
                revChecker += 10;
            }
        }


        if ((checker == 2 && mySide.equals(X)) || (checker == 20 && mySide.equals(O))) {
            return 1;
        }
        if ((revChecker == 2 && mySide.equals(X)) || (revChecker == 20 && mySide.equals(O))) {
            return -1;
        }
        if (checker == 2 || checker == 20) {
            result = 1;
        }
        if (revChecker == 2 || revChecker == 20) {
            result = -1;
        }

        return 10 * result;
    }


    public Side get(int row, int column) {
        return board[row][column];
    }
}

