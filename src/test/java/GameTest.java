import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    Board board;
    Player playerOne, playerTwo;
    Game game;

    @Before
    public void setUp(){
        board = new Board();
        playerOne = new Player("1", "X");
        playerTwo = new Player("2", "O");
        game = new Game(board);
    }
}