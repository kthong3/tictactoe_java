public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Player playerOne = new Player("1", "X");
        Player playerTwo = new Player("2", "O");
        Player[] players = {playerOne, playerTwo};

        Game game = new Game(board);
        game.start(players);
    }
}