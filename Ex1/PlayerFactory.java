/**
 * PlayerFactory class is a factory class that creates a player object based on
 * the player type.
 */
public class PlayerFactory {
    PlayerFactory() {
    }

    /**
     * This method will create a player object based on the player type.
     * @param playerType the type of player to create genius, clever, whatever, human.
     * @return the player object
    */
    public Player buildPlayer(String playerType) {
        return switch (playerType) {
            case "human" -> new HumanPlayer();
            case "whatever" -> new WhateverPlayer();
            case "clever" -> new CleverPlayer();
            case "genius" -> new GeniusPlayer();
            default -> null;
        };
    }

}