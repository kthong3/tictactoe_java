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
}