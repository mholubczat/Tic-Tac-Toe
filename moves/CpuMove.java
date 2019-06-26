package moves;

import system.Board;
import system.Side;

import java.util.Random;

import static system.Side._;

public class CpuMove {


    public void cpuMove(Board b, Side side) {

        int column;
        int row;
        //zajmij środek
        if (b.get(1, 1) == _) {
            b.setBoard(1, 1, side);
            return;
        }
        //wygrana w rzędzie
        if (b.keyRow(side) > 0) {
            row = b.keyRow(side) - 1;
            for (column = 0; column < 3; column++) {
                if (b.get(row, column) == _) {
                    b.setBoard(row, column, side);
                    return;
                }
            }
        }
        //wygrana w kolumnie
        if (b.keyCol(side) > 0) {
            column = b.keyCol(side) - 1;
            for (row = 0; row < 3; row++) {
                if (b.get(row, column) == _) {
                    b.setBoard(row, column, side);
                    return;
                }
            }
        }
        //wygrana przekątna /
        if (b.keyDia(side) == 1) {
            for (row = 0; row < 3; row++) {
                if (b.get(row, row) == _) {
                    b.setBoard(row, row, side);
                    return;
                }
            }
        }
//wygrana przekątna \
        if (b.keyDia(side) == -1) {
            for (row = 0; row < 3; row++) {
                if (b.get(2 - row, row) == _) {
                    b.setBoard(2 - row, row, side);
                    return;
                }
            }
        }

//blok rząd
        if (b.keyRow(side) < 0) {
            row = -b.keyRow(side) - 1;
            for (column = 0; column < 3; column++) {
                if (b.get(row, column) == _) {
                    b.setBoard(row, column, side);
                    return;
                }
            }
        }
        // blok kolumna
        if (b.keyCol(side) < 0) {
            column = -b.keyCol(side) - 1;
            for (row = 0; row < 3; row++) {
                if (b.get(row, column) == _) {
                    b.setBoard(row, column, side);
                    return;
                }
            }
        }
        //blok przekątna \
        if (b.keyDia(side) == 10) {
            for (row = 0; row < 3; row++) {
                if (b.get(row, row) == _) {
                    b.setBoard(row, row, side);
                    return;
                }
            }
        }
//blok przekątna /
        if (b.keyDia(side) == -10) {
            for (row = 0; row < 3; row++) {
                if (b.get(2 - row, row) == _) {
                    //System.out.println(row);
                    b.setBoard(2 - row, row, side);
                    return;
                }
            }
        }
        //losowe niezajęte pole
        Random random = new Random();
        do {
            row = random.nextInt(3);
            column = random.nextInt(3);
            if (b.get(row, column) == _) {

                b.setBoard(row, column, side);
                return;
            }
        }
        while (b.get(row, column) != _);


    }
}