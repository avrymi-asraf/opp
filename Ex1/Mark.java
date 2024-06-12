public enum Mark {
    /**
     * The possible marks on the board.
     */
    BLANK, X, O;

    @Override
    public String toString() {
        return switch (this) {
            case X -> "X";
            case O -> "O";
            default -> null;
        };
    }
}