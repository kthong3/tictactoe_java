public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player playerOne = new Player("X");
        Player playerTwo = new Player("O");
        Player[] players = {playerOne, playerTwo};

        Game game = new Game(board);
        game.start(players);
    }
}