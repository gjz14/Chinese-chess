package chess.chessman;

import chess.Piece;

import java.util.ArrayList;
import java.util.List;

import chess.Board;
import chess.Common;

public class Shuai extends Piece {
    public Shuai(int x, int y, int color) {
        super(x, y, color);
    }

    public String get_img() {
        if (this.color == 1)
            return "img/bb.png";
        else
            return "img/rb.png";
    }

    public boolean checkFaceKing(int x, int y, Board board){
        int delta_x = (color==0)?-1:1;
        int dx = x+delta_x,dy = y;
        while(Common.isInBoard(dx, dy) && board.getColor(dx, dy) == -1 )
            dx += delta_x;
        if(Common.isInBoard(dx, dy) && board.pieces.get(Common.encoder(dx, dy)).getClass()==Shuai.class)
            return true;
        return false;
    }

    public List<Integer> getMoveLocations(int x, int y, Board board) {
        List<Integer> locs = new ArrayList<>();
        int dirs[] = new int[]{0,1,0,-1,0};
        for(int i=0;i<4;i++){
            int delta_x = dirs[i], delta_y = dirs[i+1];
            int dx = x+delta_x, dy = y+delta_y;
            if(Common.isInPalace(dx, dy, color) && board.getColor(dx, dy)!=color &&!checkFaceKing(dx, dy, board))
                locs.add(Common.encoder(dx, dy));
        }
        return locs;
    }
}