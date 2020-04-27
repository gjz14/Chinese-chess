package chess.chessman;

import chess.Piece;
import chess.Board;
import chess.Common;

public class Bing extends Piece{
    public Bing(int x,int y,int color){
        super(x, y, color);
    }
    public String get_img(){
        if(this.color==1)
            return "img/bz.png";
        else
            return "img/rz.png";
    }
    public void move(int dx, int dy, Board board){
        board.remove(x, y);
        this.x = dx;
        this.y = dy;
        board.pieces.put(Common.encoder(x, y), this);
    }
    
    public int[] getMoveLocations(int x,int y, Board board){
        int [] res = new int [1];
        return res;
    }

}