import java.util.Random;
/**
 * This class represents whatever player in the game of Tic-Tac-Toe.
 * the player will play in random row and column.
 */
public class WhateverPlayer implements Player {
    private final Random random = new Random();

    public WhateverPlayer() {
        
    }

    private boolean isCellEmpty(Board board, int row, int column) {
        return board.getMark(row, column) == Mark.BLANK;
    }

    /**
     * This method will play the turn for the player.
     * The player will play in random row and column.
     * @param board the board to play on
     * @param mark the mark to play
     */
    public void playTurn(Board board, Mark mark) {
        int size = board.getSize();
        int row = random.nextInt(size);
        int column = random.nextInt(size);
        while (!isCellEmpty(board, row, column)) {
            row = random.nextInt(size);
            column = random.nextInt(size);
        }
        board.putMark(row, column, mark);
    }
}   