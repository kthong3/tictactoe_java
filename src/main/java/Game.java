import java.util.Scanner;

public class Game {
    Board board;

    public Game(Board board){
        this.board = board;
    }

    public void start(Player[] players){
        System.out.println("Starting tic tac toe game..");
        board.display();
        String chosenLocation = askForLocation();
        board.markLocation(chosenLocation, players[0]);
    }

    private String askForLocation(){
        System.out.println("Player 1, please choose a spot to mark by typing in number [0-8]:");
        Scanner scanner = new Scanner(System.in);
        String spot = scanner.nextLine();
        return spot;
    }
}
