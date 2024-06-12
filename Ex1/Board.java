import java.util.Arrays;

public class Board {
    final int size;
    final Mark[][] board;

    /**
     * Create a board with the given size
     *
     * @param size the size of the board
     */
    public Board(int size) {
        this.size = size;
        board = new Mark[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(board[i], Mark.BLANK);
        }
    }

    public Board() {
        this(4);
    }

    public int getSize() {
        return size;
    }

    /**
     * Put a mark on the board
     *
     * @param x    row index
     * @param y    column index
     * @param mark the mark to put
     * @return true if the mark is put successfully, false otherwise
     */
    public boolean putMark(int x, int y, Mark mark) {
        if (x < 0 || x >= size || y < 0 || y >= size || board[x][y] != Mark.BLANK) {
            return false;
        }
        board[x][y] = mark;
        return true;
    }

    /**
     * Get the mark at the given position
     *
     * @param x row index
     * @param y column index
     * @return the mark at the given position,default is Mark.BLANK or if the position is out of bound
     */
    public Mark getMark(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            return Mark.BLANK;
        }
        return board[x][y];
    }
}