package pl.sda.poznan;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static String getPlayerName() {
        System.out.println("Enter your nickname: ");
        return sc.next();
    }

    public static void main(String[] args) {

        Player firstPlayer = new Player(getPlayerName(), PlayerConstants.X_PLAYER_SIGN);
        Player secondPlayer = new Player(getPlayerName(), PlayerConstants.O_PLAYER_SIGN);
        GameBoard gameBoard = new GameBoard();

        Game game = new Game(firstPlayer, secondPlayer, gameBoard);
        boolean finishGame = false;

        System.out.println("First move for player " + game.getCurrentPlayer().getName());
        while (!finishGame) {
            String move = sc.next();
            GameStatus gameStatus = game.playGame(move);
            gameBoard.print();
            switch (gameStatus) {
                case BAD_MOVE: {
                    System.out.println("\nBad move, type again.");
                    break;
                }
                case WINNER: {
                    finishGame = true;
                    System.out.println("\nGame finished successfully.");
                }
                case CORRECT_MOVE:{
                    System.out.println("\nTime to move for player " + game.getCurrentPlayer());
                }

            }
        }
    }
}
