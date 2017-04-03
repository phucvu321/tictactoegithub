package tictactoegit;

 
import java.util.Collections;



public class Board {
    private char X = 'X';
    private char O = 'O';
    private String horizontalDraw = "+ - ";
    private String verticalDraw = "| ";
    private int size;
    public char[][] coorD = new char[size + 2][size + 2];;
    public Board(int size) {
        coorD = new char[size + 1][size + 1];;
        this.size = size;
        for (int x = 1; x < this.size + 1; x++) {
            for (int y = 1; y < this.size + 1; y++) {
                coorD[x][y] = Character.MIN_VALUE;
            }
        }


    }

    public void addCoorD(int x, int y, int player) {
        if (coorD[x][y] == Character.MIN_VALUE) {
            if (player == 1) {
                coorD[x][y] = X;
            } else {
                coorD[x][y] = O;
            }
        }

    }
    public void draw() {

        int height = 0;
        while (height < size) {
            for (int i = 0; i < size; i++) {
                System.out.print(horizontalDraw);

            }
            System.out.print('+' + "\n");
            for (int i = 0; i < size; i++) {
                System.out.print(verticalDraw + coorD[i + 1][height + 1] + " ");

            }
            System.out.print('|' + "\n");

            height++;
        } //end of while
        for (int i = 0; i < size; i++) {
            System.out.print(horizontalDraw);

        }
        System.out.println('+');
        System.out.println(" ");

    }

    public int checkWin() {
        int xcounter = 0;
        int ocounter = 0;
        //check collumns
        for (int x = 1; x < size + 1; x++) {
            xcounter = 0;
            ocounter = 0;
            for (int y = 1; y < size + 1; y++) {
                if (coorD[x][y] == Character.MIN_VALUE) break;
                else
                if (coorD[x][y] == O) {
                    ocounter++;
                    if (ocounter == size) return 0;
                } else
                if (coorD[x][y] == X) {
                    xcounter++;
                    if (xcounter == size) return 1;
                }

                if (xcounter > 0 && ocounter > 0) break;

            }

        }

        xcounter = 0;
        ocounter = 0;
        //check rows
        for (int y = 1; y < size + 1; y++) {
            xcounter = 0;
            ocounter = 0;
            for (int x = 1; x < size + 1; x++) {
                if (coorD[x][y] == Character.MIN_VALUE) break;
                else
                if (coorD[x][y] == O) {
                    ocounter++;
                    if (ocounter == size) return 0;
                } else
                if (coorD[x][y] == X) {
                    xcounter++;
                    if (xcounter == size) return 1;
                }

                if (xcounter > 0 && ocounter > 0) break;

            }

        }

        xcounter = 0;
        ocounter = 0;
        //check diagonals
        for (int y = 1; y < size + 1; y++) {

            for (int x = 1; x < size + 1; x++) {

                if (x == y) {
                    if (coorD[x][y] == Character.MIN_VALUE) break;
                    else
                    if (coorD[x][y] == O) {
                        ocounter++;
                        if (ocounter == size) return 0;
                    } else
                    if (coorD[x][y] == X) {
                        xcounter++;
                        if (xcounter == size) return 1;
                    }

                    if (xcounter > 0 && ocounter > 0) break;
                }
            }

        }

        xcounter = 0;
        ocounter = 0;
        int x = 1;
        for (int y = size; y > 0; y--) {

            if (coorD[x][y] == Character.MIN_VALUE) break;
            else
            if (coorD[x][y] == O) {
                ocounter++;
                if (ocounter == size) return 0;
            } else
            if (coorD[x][y] == X) {
                xcounter++;
                if (xcounter == size) return 1;
            }

            if (xcounter > 0 && ocounter > 0) break;

            x++;


        }
        if (xcounter == size) return 1;
        if (ocounter == size) return 0;
        int counter = 0;
        for (int y = 1; y < size + 1; y++) {
            for (x = 1; x < size + 1; x++) {
                if (coorD[x][y] == Character.MIN_VALUE) break;
                else
                if (coorD[x][y] == O || coorD[x][y] == X) counter++;


            }
        }
        if (counter == size * size) return -1;
        return 2;
    }
}