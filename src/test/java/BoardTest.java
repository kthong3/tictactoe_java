import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class BoardTest {

    Board board;
    Player playerOne, playerTwo;

    @Before
    public void setUp(){
        board = new Board();
        playerOne = new Player("1", "X");
        playerTwo = new Player("2", "O");
    }

    @Test
    public void markLocation_shouldReturnAddNewMarkToLocations(){
        Random rand = new Random();
        int randomNumZeroToEight = rand.nextInt((8 - 0) + 1) + 0;
        String chosenLocation = Integer.toString(randomNumZeroToEight);

        board.markLocation(chosenLocation, playerTwo);
        String[] boardLocations = board.locations();
        List board = Arrays.asList(boardLocations);

        assertTrue(board.contains(playerTwo.symbol()));
    }

    @Test
    public void locationAlreadyTaken_shouldReturnTrueWhenSpotHasBeenMarked(){
        Random rand = new Random();
        int randomNumZeroToEight = rand.nextInt((8 - 0) + 1) + 0;
        String chosenLocation = Integer.toString(randomNumZeroToEight);

        board.markLocation(chosenLocation, playerOne);
        assertTrue(board.locationAlreadyTaken(chosenLocation));
    }

    @Test
    public void locationAlreadyTaken_shouldReturnFalseWhenSpotHasNotBeenMarkedYet(){
        board.markLocation("1", playerOne);

        assertFalse(board.locationAlreadyTaken("2"));
    }

    @Test
    public void isFilled_shouldReturnTrueWhenAllSpotsHaveBeenTaken(){
        String[] boardLocations = new String[]{"X", "O", "X", "O", "X", "O", "O", "X", "O"};
        board.setLocations(boardLocations);

        assertTrue(board.isFilled());
    }

    @Test
    public void isFilled_shouldReturnFalseWhenNotAllSpotsHaveBeenTaken(){
        String[] boardLocations = new String[]{"X", "O", "X", "O", "X", "O", "O", "X", "8"};
        board.setLocations(boardLocations);

        assertFalse(board.isFilled());
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInFirstRow() {
        String[] xInFirstRow = new String[]{"X", "X", "X", "O", "4", "O", "6", "7", "O"};
        board.setLocations(xInFirstRow);

        assertTrue(board.determineWinner(playerOne));
        assertFalse(board.determineWinner(playerTwo));
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInMiddleRow() {
        String[] xInMiddleRow = new String[]{"0", "O", "2", "X", "X", "X", "O", "7", "O"};
        board.setLocations(xInMiddleRow);

        assertTrue(board.determineWinner(playerOne));
        assertFalse(board.determineWinner(playerTwo));
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInLastRow() {
        String[] xInLastRow = new String[]{"O", "1", "O", "O", "4", "5", "X", "X", "X"};
        board.setLocations(xInLastRow);

        assertTrue(board.determineWinner(playerOne));
        assertFalse(board.determineWinner(playerTwo));
    }

    @Test
    public void determineWinner_shouldReturnFalseWhenThereAreNoWinningCombo() {
        String[] noWinningCombo = new String[]{"X", "O", "X", "O", "X", "O", "O", "X", "O"};
        board.setLocations(noWinningCombo);

        assertFalse(board.determineWinner(playerOne));
        assertFalse(board.determineWinner(playerTwo));
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInFirstColumn() {
        String[] xInFirstColumn = new String[]{"X", "O", "O", "X", "O", "O", "X", "7", "8"};
        board.setLocations(xInFirstColumn);

        assertTrue(board.determineWinner(playerOne));
        assertFalse(board.determineWinner(playerTwo));
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInMiddleColumn() {
        String[] xInMiddleColumn = new String[]{"0", "X", "O", "O", "X", "5", "O", "X", "8"};
        board.setLocations(xInMiddleColumn);

        assertTrue(board.determineWinner(playerOne));
        assertFalse(board.determineWinner(playerTwo));
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetInLastColumn() {
        String[] xInLastColumn = new String[]{"0", "O", "X", "O", "4", "X", "O", "7", "X"};
        board.setLocations(xInLastColumn);

        assertTrue(board.determineWinner(playerOne));
        assertFalse(board.determineWinner(playerTwo));
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetDiagonallyLeftTopToRightBottom() {
        String[] xLTopToRBottom = new String[]{"X", "O", "O", "3", "X", "5", "O", "7", "X"};
        board.setLocations(xLTopToRBottom);

        assertTrue(board.determineWinner(playerOne));
        assertFalse(board.determineWinner(playerTwo));
    }

    @Test
    public void determineWinner_shouldReturnTrueWhenBoardFindsWinningSetDiagonallyLeftBottomToRightTop() {
        String[] xLBottomToRTop = new String[]{"O", "1", "X", "O", "X", "O", "X", "7", "O"};
        board.setLocations(xLBottomToRTop);

        assertTrue(board.determineWinner(playerOne));
        assertFalse(board.determineWinner(playerTwo));
    }

}