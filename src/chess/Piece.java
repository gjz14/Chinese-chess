package chess;

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
    
    abstract public void move(int dx, int dy, Board board);

    abstract public String get_img();

    abstract public int[] getMoveLocations(int x,int y, Board board);

}


