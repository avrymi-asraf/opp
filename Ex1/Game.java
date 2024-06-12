
public class Game {
    /**
     * This class represents a one game of Tic-Tac-Toe.
     */
    private final Board board;
    private final Renderer renderer;
    private final Player[] players;
    private int numSteps;
    private static final Mark[] marks = { Mark.X, Mark.O };
    private final int winStreak;

    /**
     * Constructor for the Game class.
     * 
     * @param playerX   player playing as X
     * @param playerO   player playing as O
     * @param size      size of the board
     * @param winStreak number of marks in a row to win
     * @param renderer  how to render the board
     */
    public Game(Player playerX, Player playerO, int size, int winStreak, Renderer renderer) {

        players = new Player[] { playerX, playerO };
        this.renderer = renderer;
        if (size < winStreak || winStreak < 2) {
            winStreak = size;
        }
        this.winStreak = winStreak;
        board = new Board(size);
        numSteps = 0;
    }

    /**
     * Constructor for the Game class.
     * 
     * @param playerX  player playing as X
     * @param playerO  player playing as O
     * @param renderer how to render the board
     */
    public Game(Player playerX, Player playerO, Renderer renderer) {
        this(playerX, playerO, 4, 3, renderer);
    }

    public int getWinStreak() {
        return winStreak;
    }

    public int getBoardSize() {
        return board.getSize();
    }

    /**
     * Run the game.
     * 
     * @return the winner of the game
     */
    public Mark run() {
        int turn = 0;
        while (boardNotFull() && winner() == Mark.BLANK) {
            players[turn].playTurn(board, marks[turn]);
            renderer.renderBoard(board);
            numSteps++;
            turn = 1 - turn;

        }
        return winner();
    }

    private Mark winner() {
        for (Mark win : new Mark[] { checkColumns(), checkDiagonals(), checkRows() }) {
            if (win != Mark.BLANK) {
                return win;
            }
        }
        return Mark.BLANK;
    }

    private boolean boardNotFull() {
        return numSteps < board.getSize() * board.getSize();
    }

    private Mark checkRows() {
        int size = board.getSize();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col <= size - winStreak; col++) {
                Mark first = board.getMark(row, col);
                if (first != Mark.BLANK) {
                    boolean win = true;
                    for (int k = 1; k < winStreak; k++) {
                        if (board.getMark(row, col + k) != first) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return first;
                    }
                }
            }
        }
        return Mark.BLANK;
    }

    private Mark checkColumns() {
        int size = board.getSize();
        for (int col = 0; col < size; col++) {
            for (int row = 0; row <= size - winStreak; row++) {
                Mark first = board.getMark(row, col);
                if (first != Mark.BLANK) {
                    boolean win = true;
                    for (int k = 1; k < winStreak; k++) {
                        if (board.getMark(row + k, col) != first) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return first;
                    }
                }
            }
        }
        return Mark.BLANK;
    }

    private Mark checkDiagonals() {
        int size = board.getSize();

        // Check main diagonals (top-left to bottom-right)
        for (int row = 0; row <= size - winStreak; row++) {
            for (int col = 0; col <= size - winStreak; col++) {
                Mark first = board.getMark(row, col);
                if (first != Mark.BLANK) {
                    boolean win = true;
                    for (int k = 1; k < winStreak; k++) {
                        if (board.getMark(row + k, col + k) != first) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return first;
                    }
                }
            }
        }

        // Check anti-diagonals (top-right to bottom-left)
        for (int row = 0; row <= size - winStreak; row++) {
            for (int col = winStreak - 1; col < size; col++) {
                Mark first = board.getMark(row, col);
                if (first != Mark.BLANK) {
                    boolean win = true;
                    for (int k = 1; k < winStreak; k++) {
                        if (board.getMark(row + k, col - k) != first) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return first;
                    }
                }
            }
        }

        return Mark.BLANK;
    }

}