import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    Board board;
    Player playerOne, playerTwo;

    @Before
    public void setUp(){
        board = new Board();
        playerOne = new Player("X");
        playerTwo = new Player("O");
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInFirstRow() {
        String[] xInFirstRow = new String[]{"X", "X", "X", "3", "4", "5", "6", "7", "8"};
        board.setLocations(xInFirstRow);

        assertTrue(board.determineWinner(playerOne));
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInMiddleRow() {
        String[] xInMiddleRow = new String[]{"0", "1", "2", "X", "X", "X", "6", "7", "8"};
        board.setLocations(xInMiddleRow);

        assertTrue(board.determineWinner(playerOne));
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInLastRow() {
        String[] xInLastRow = new String[]{"0", "1", "2", "3", "4", "5", "X", "X", "X"};
        board.setLocations(xInLastRow);

        assertTrue(board.determineWinner(playerOne));
    }
}