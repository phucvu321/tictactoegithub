package tictactoegit;

 

import java.util.Scanner;





public class main {
    final static int IS_X = 1;
    final static int IS_O = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int human = IS_X;
        int comp = IS_O;



        System.out.println("enter the size of the board EX. 4");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();

        Board board = new Board(size);
        //  board.addCoorD(3,2,human);   
        //  board.addCoorD(1, 2, comp); board.addCoorD(1, 3, comp); //board.addCoorD(1, 4, comp);
        AI ai = new AI(comp, size);


        String string = "";
        System.out.println("////////////");
        System.out.println("enter coordinate EX: 1,2");
        string = input.next();
        while (string != "quit") {

            if (string == "quit") break;
            System.out.println("\n");
            String parts[] = null;
            try {
                parts = string.split(",");


            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println(e);
            }
            int x = 0;
            int y = 0;
            try {

                x = Integer.parseInt(parts[0]);
                y = Integer.parseInt(parts[1]);
                board.addCoorD(x, y, human);
                board.draw();
                if (board.checkWin() == -1 || board.checkWin() == 1) break;
                moves move = ai.getMove(3, board);
                board.addCoorD(move.x, move.y, comp);

                board.draw();
                if (board.checkWin() == -1 || board.checkWin() == 0) break;

            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("enter coordinate o quit");
                string = input.nextLine();
                System.out.println("\n");

            }

            System.out.println("enter coordinate example: 1,2");
            string = input.next();
        }

        System.out.println("ended");
    }

}