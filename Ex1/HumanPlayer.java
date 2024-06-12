/**
 * HumanPlayer class implements the Player interface and represents a human player in the game.
 */
public class HumanPlayer implements Player {
    private boolean inBoard(Board board, int row, int column) {
        return row >= 0 && row < board.getSize() && column >= 0 && column < board.getSize();
    }

    private boolean isCellEmpty(Board board, int row, int column) {
        return board.getMark(row, column) == Mark.BLANK;
    }

    public HumanPlayer() {
    }

    /**
     * This method will play the turn for the player.
     * The player will play by taking input from the user.
     *
     * @param board the board to play on
     * @param mark  the mark to play
     */
    public void playTurn(Board board, Mark mark) {

        System.out.printf("Player %s, type coordinates: ", mark);
        while (true) {
            int rowColumn = KeyboardInput.readInt();
            int row = rowColumn / 10;
            int column = rowColumn % 10;

            if (inBoard(board, row, column) && isCellEmpty(board, row, column)) {
                board.putMark(mark, row, column);
                break;
            }
            if (!inBoard(board, row, column)) {
                System.out.print(
                        "Invalid mark position, please choose a different position.\n");
            } else if (!isCellEmpty(board, row, column)) {
                System.out.println("Mark position is already occupied.\n");
            }
            System.out.print("Invalid coordinates, type again: ");

        }
    }
}