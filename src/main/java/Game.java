import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    Board board;

    public Game(Board board){
        this.board = board;
    }

    public void start(Player[] players){
        System.out.println("Starting tic tac toe game..");
        board.display();
        while(!board.isFilled()){
            turn(players);
        }
        if (board.isFilled()){
            System.out.println("it's a draw!");
        }
    }

    private String askForLocation(String playerNumber){
        String prompt = String.format("Player %s, please choose a spot to mark by typing in number [0-8]:", playerNumber);
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        String spot = scanner.nextLine();
        return spot;
    }

    private void turn(Player[] players){
        for (Player player: players) {
            String chosenLocation = askForLocation(player.number());

            while (board.locationAlreadyTaken(chosenLocation)){
                System.out.println("Sorry, that spot was already taken.");
                chosenLocation = askForLocation(player.number());
            }
            board.markLocation(chosenLocation, player);
            board.display();
            if (board.isFilled()){return;}
        }
    }
}
