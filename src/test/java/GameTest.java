import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    Board board;
    Player playerOne, playerTwo;
    Player[] players;
    Game game;

    @Before
    public void setUp(){
        board = new Board();
        playerOne = new Player("1", "X");
        playerTwo = new Player("2", "O");
        game = new Game(board);
    }

    @Test
    public void results_shouldDeclareDrawIfBoardHasBeenFilledAndNoWinnerFound(){
        players = new Player[]{playerOne, playerTwo};
        String[] noWinningCombo = new String[]{"X", "O", "X", "O", "X", "O", "O", "X", "O"};
        board.setLocations(noWinningCombo);

        String expectedResult = "It's a draw!";
        String result = game.results(players);

        assertEquals(expectedResult, result);
    }

    @Test
    public void results_shouldDeclareWinnerWhenPlayerOneWins(){
        players = new Player[]{playerOne, playerTwo};
        String[] xWinningCombo = new String[]{"X", "X", "X", "O", "X", "O", "O", "X", "O"};
        board.setLocations(xWinningCombo);

        String expectedResult = "Player 1 wins!";
        String result = game.results(players);

        assertEquals(expectedResult, result);
    }

    @Test
    public void results_shouldDeclareWinnerWhenPlayerTwoWins(){
        players = new Player[]{playerOne, playerTwo};
        String[] oWinningCombo = new String[]{"X", "O", "X", "O", "X", "O", "O", "O", "O"};
        board.setLocations(oWinningCombo);

        String expectedResult = "Player 2 wins!";
        String result = game.results(players);

        assertEquals(expectedResult, result);
    }

}