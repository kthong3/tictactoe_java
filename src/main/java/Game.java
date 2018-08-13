public class Game {
    Board board;

    public Game(Board board){
        this.board = board;
    }

    public void start(Player[] players){
        board.display();
    }
}
