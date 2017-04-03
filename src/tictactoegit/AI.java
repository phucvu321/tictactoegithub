package tictactoegit;

 

import java.util.ArrayList;
import java.util.List;






public class AI {
    // final static int CPU_POWER =50000000;
    final static int CPU_POWER = 5000000;
    int comp;
    int human;
    moves move;
    int depth;
    int computationTime;
    List < moves > possibleMoves;
    public AI(int player, int size) {
        moves move = new moves();
        this.comp = player;
        if (comp == 1) human = 0;
        else human = 1;

        possibleMoves = new ArrayList < moves > ((size * size) + 1);
        for (int x = 1; x < size + 1; x++) {
            for (int y = 1; y < size + 1; y++) {
                moves tempMoves = new moves();
                tempMoves.x = x;
                tempMoves.y = y;
                possibleMoves.add(tempMoves);
            }
        }

    }
    public moves getMove(int difficulty, Board board) {

        computationTime = 0;
        depth = 0;
        if (difficulty == 1) return easyMove(board);
        else if (difficulty == 2) return mediumMove(board);
        else if (difficulty == 3) {
            return hardMove(board, comp, depth);
        } else return hardMove(board, comp, depth);
    }
    public moves easyMove(Board board) {
        return move;
    }
    public moves mediumMove(Board board) {
        return move;
    }
    public moves hardMove(Board board, int player, int depth) {


        computationTime++;
        int win = board.checkWin();
        depth++;
        if (win == comp) {
            moves move = new moves();
            move.score = 10 - depth;
            return move;
        } else if (win == human) {
            moves move = new moves();
            move.score = depth - 10;
            return move;
        } else if (win == -1) {
            moves move = new moves();
            move.score = 0;
            return move;
        } else if (computationTime > CPU_POWER) {
            moves move = new moves();
            move.score = 0;
            return move;
        }
        List < moves > moves = new ArrayList < moves > ();
        for (moves move: possibleMoves) {
            int x = move.x;
            int y = move.y;

            if (board.coorD[x][y] == Character.MIN_VALUE) {
                board.addCoorD(x, y, player);
                moves tempMove = new moves();
                tempMove.x = x;
                tempMove.y = y;

                if (player == comp) {

                    tempMove.score = hardMove(board, human, depth).score;
                } else {
                    tempMove.score = hardMove(board, comp, depth).score;
                }
                moves.add(tempMove);
                board.coorD[x][y] = Character.MIN_VALUE;

            }

        }
        int bestMove = 0;
        if (player == comp) {
            int bestScore = Integer.MIN_VALUE;
            // int bestScore = -10000000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score > bestScore) {
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        } else {
            int bestScore = Integer.MAX_VALUE;
            // int bestScore = 10000000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score < bestScore) {
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }

        }
        //System.out.println(levels);
        if (depth == 1) {

            board.addCoorD(moves.get(bestMove).x, moves.get(bestMove).y, comp);
            for (moves move: possibleMoves) {
                moves temp = new moves();
                int x = move.x;
                int y = move.y;

                if (board.coorD[x][y] == Character.MIN_VALUE) {
                    board.addCoorD(x, y, human);
                    if (board.checkWin() == human) {
                        temp.x = x;
                        temp.y = y;
                        board.coorD[x][y] = Character.MIN_VALUE;
                        moves.clear();
                        return temp;
                    }
                    board.coorD[x][y] = Character.MIN_VALUE;
                    board.coorD[moves.get(bestMove).x][moves.get(bestMove).y] = Character.MIN_VALUE;
                }

            }
        }
        moves temp = moves.get(bestMove);
        moves.clear();

        return temp;

    }

}