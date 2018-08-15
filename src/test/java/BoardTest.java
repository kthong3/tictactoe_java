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
    public void locationAlreadyTaken_shouldReturnTrueIfSpotHasBeenMarked(){
        Random rand = new Random();
        int randomNumZeroToEight = rand.nextInt((8 - 0) + 1) + 0;
        String chosenLocation = Integer.toString(randomNumZeroToEight);

        board.markLocation(chosenLocation, playerOne);
        assertTrue(board.locationAlreadyTaken(chosenLocation));
    }

    @Test
    public void locationAlreadyTaken_shouldReturnFalseIfSpotHasNotBeenMarkedYet(){
        board.markLocation("1", playerOne);

        assertFalse(board.locationAlreadyTaken("2"));
    }
}