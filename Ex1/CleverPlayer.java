/**
 * class CleverPlayer
 */
public class CleverPlayer implements Player {
    public CleverPlayer() {
    }

    /**
     * get the next move by filling the first empty cell in the board
     * from left to right and top to bottom.
     *
     * @param board the board to play on
     * @param mark  the mark to play
     */
    public void playTurn(Board board, Mark mark) {

        int size = board.getSize();
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (board.getMark(row, column) == Mark.BLANK) {
                    board.putMark(mark, row, column);
                    return;
                }
            }
        }
    }

}