
import chess.Board;
import view.GameView;
public class Game {
    private Board board;
    private GameView view;
    public static void main(final String[] args) {
        final Game game = new Game();
        game.init();
        game.run();
    }

    public void init() {
        final GameView view = new GameView();
        final Board board = new Board();
        view.draw_board(board);
    }
    
    public void run(){

    }

}