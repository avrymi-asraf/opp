/**
 * The Tournament class is responsible for running a series of games between two players.
 */
public class Tournament {
    private final int TIES = 2;
    private final int[] scoreTable;
    private final int rounds;
    private final Player[] players;
    private final Renderer renderer;

    /**
     * Constructor for the Tournament class.
     *
     * @param rounds   the number of rounds to play
     * @param renderer the renderer to use
     * @param player1
     * @param player2
     */
    public Tournament(int rounds, Renderer renderer, Player player1, Player player2) {
        this.rounds = rounds;
        scoreTable = new int[]{0, 0, 0};
        players = new Player[]{player1, player2};
        this.renderer = renderer;

    }

    /**
     * This method will play the tournament between two players.
     *
     * @param size        the size of the board
     * @param winStreak   the number of marks in a row to win
     * @param playerName1 the name of the first player
     * @param playerName2 the name of the second player
     */
    public void playTournament(int size, int winStreak,
                               String playerName1, String playerName2) {
        int xInd = 0;
        int oInd = 1;
        for (int i = 1; i <= rounds; i++) {
            Game game = new Game(players[xInd], players[oInd], size, winStreak, this.renderer);
            Mark win = game.run();
            switch (win) {
                case Mark.X:
                    scoreTable[xInd]++;
                    break;
                case Mark.O:
                    scoreTable[oInd]++;
                    break;
                default:
                    scoreTable[TIES]++;
            }

            xInd = 1 - xInd;
            oInd = 1 - oInd;

        }
        System.out.printf(
                """
                ######### Results #########
                Player 1, %s won: %d rounds
                Player 2, %s won: %d rounds
                Ties: %d""", playerName1, scoreTable[0], playerName2, scoreTable[1],
                scoreTable[2]);
    }

    private static void printUsage() {
        System.out.println("""
       Usage: Please run the game again: java Tournament [round count] [size] [win_streak]
       [render target: console/none] [first player: human/whatever/clever/genius] [second
       player: human/whatever/clever/genius]""");
    }

    public static void main(String[] args) {
        if (args.length != 7) {
            throw new IllegalArgumentException(
                    "Invalid number of arguments. Expected 7, got " + args.length);
        }

        int roundCount = Integer.parseInt(args[1]);
        if (roundCount < 1) {
            throw new IllegalArgumentException(
                    "Invalid number of rounds. Expected a positive integer, got " + args[1]);
        }

        int size = Integer.parseInt(args[2]);
        if (size < 2 || size > 9) {
            throw new IllegalArgumentException(
                    "Invalid board size. Expected an integer between 2 and 9, got " + args[2]);
        }

        int winStreak = Integer.parseInt(args[3]);
        if (winStreak < 2 || winStreak > size) {
            throw new IllegalArgumentException(
                    "Invalid win streak. Expected an integer between 2 and " +
                    size +
                    ", got " +
                    args[3]);
        }

        RendererFactory rendererFactory = new RendererFactory();
        Renderer renderer = rendererFactory.buildRenderer(args[4], size);
        if (renderer == null) {
            printUsage();
            return;
        }

        PlayerFactory playerFactory = new PlayerFactory();

        Player player1 = playerFactory.buildPlayer(args[5]);
        if (player1 == null) {
            printUsage();
            return;
        }
        Player player2 = playerFactory.buildPlayer(args[6]);
        if (player2 == null) {
            printUsage();
            return;
        }

        Tournament tournament = new Tournament(roundCount, renderer, player1, player2);
        tournament.playTournament(size, winStreak, args[5], args[6]);
    }
}