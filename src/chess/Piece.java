package chess;

import java.util.ArrayList;
import java.util.List;

import chess.Board;
import chess.Common;

abstract public class Piece {
    public int x;
    public int y;
    public int color; // 0 for red, 1 for black
    public Piece(int x,int y,int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public boolean move(int dx, int dy, Board board){
        List<Integer> canMoves = getMoveLocations(x, y, board);
        int pos = Common.encoder(dx, dy);
        if(!canMoves.contains(pos))
            return false;
        board.remove(x, y);
        this.x = dx;
        this.y = dy;
        // eat
        board.remove(dx, dy);
        board.pieces.put(Common.encoder(x, y), this);
        return true;
    };

    abstract public String get_img();

    abstract public List<Integer> getMoveLocations(int x,int y, Board board);

}


