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

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInFirstColumn() {
        String[] xInFirstColumn = new String[]{"X", "1", "2", "X", "4", "5", "X", "7", "8"};
        board.setLocations(xInFirstColumn);

        assertTrue(board.determineWinner(playerOne));
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInMiddleColumn() {
        String[] xInMiddleColumn = new String[]{"0", "X", "2", "3", "X", "5", "6", "X", "8"};
        board.setLocations(xInMiddleColumn);

        assertTrue(board.determineWinner(playerOne));
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInLastColumn() {
        String[] xInLastColumn = new String[]{"0", "1", "X", "3", "4", "X", "6", "7", "X"};
        board.setLocations(xInLastColumn);

        assertTrue(board.determineWinner(playerOne));
    }

}