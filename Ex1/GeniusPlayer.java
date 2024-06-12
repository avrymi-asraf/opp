import java.util.Random;

/**
 * This class represents genius player in the game of Tic-Tac-Toe.
 * the player will play in from top to bottom from random column.
 */
public class GeniusPlayer implements Player {
    private final Random random = new Random();

    public GeniusPlayer() {
    }

    /**
     * This method will play the turn for the player.
     * The player will play from top to bottom from random column.
     * @param board the board to play on
     * @param mark the mark to play
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        int row = 0;
        int col = random.nextInt(1,board.getSize());
        while (true) {
            if (board.getMark(row, col) == Mark.BLANK) {
                board.putMark(row, col, mark);
                return;
            }
            row = (row + 1) % board.getSize();
            if (row == 0) {
                col = (col + 1) % board.getSize();
            }

        }

    }
}
