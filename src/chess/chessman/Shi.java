package chess.chessman;

import chess.Piece;
import chess.Board;
import chess.Common;

public class Shi extends Piece{
    public Shi(int x,int y,int color){
        super(x, y, color);
    }
    public String get_img(){
        if(this.color==1)
            return "img/bs.png";
        else
            return "img/rs.png";
    }
    public void move(int dx, int dy, Board board){

    }
    public int[] getMoveLocations(int x,int y, Board board){
        int [] res = new int [1];
        return res;
    }
}