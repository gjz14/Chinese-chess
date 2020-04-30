
import chess.Board;
import view.GameView;
public class Game {
    private Board board;
    private GameView view;
    public static void main(final String[] args) {
        final Game game = new Game();
        game.run();
    }

    public void run() {
        final GameView view = new GameView();
        final Board board = new Board();
        view.init_board(board);
    }

}