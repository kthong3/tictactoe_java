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

        while(!isOver(players)){
            for (Player player: players) {
                turn(player);
                if(isOver(players)){
                    break;
                }
            }
        }
        System.out.println(results(players));
    }

    private String askForLocation(String playerNumber){
        String prompt = String.format("Player %s, please choose a spot to mark by typing in number [0-8]:", playerNumber);
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        String spot = scanner.nextLine();
        return spot;
    }

    private void turn(Player player){
        String chosenLocation = askForLocation(player.number());

        while (board.locationAlreadyTaken(chosenLocation)){
            System.out.println("Sorry, that spot was already taken.");
            chosenLocation = askForLocation(player.number());
        }

        board.markLocation(chosenLocation, player);
        board.display();
    }

    private boolean isOver(Player[] players){
        return board.determineWinner(players[0]) || board.determineWinner(players[1]) || board.isFilled();
    }

    public String results(Player[] players){
        if (board.determineWinner(players[0])){
            return String.format("Player %s wins!", players[0].number());

        }
        else if (board.determineWinner(players[1])){
            return String.format("Player %s wins!", players[1].number());
        }
        else return "It's a draw!";
    }
}
