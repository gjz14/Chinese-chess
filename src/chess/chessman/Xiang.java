package chess.chessman;

import chess.Piece;

import java.util.ArrayList;
import java.util.List;

import chess.Board;
import chess.Common;

public class Xiang extends Piece {
    public Xiang(int x, int y, int color) {
        super(x, y, color);
    }

    public String get_img() {
        if (this.color == 1)
            return "img/bx.png";
        else
            return "img/rx.png";
    }


    public List<Integer> getMoveLocations(int x, int y, Board board) {
        List<Integer> locs = new ArrayList<>();
        int []dirs = new int[]{2,-2,-2,2,2};
        for(int i=0;i<4;i++){
            int delta_x = dirs[i], delta_y = dirs[i+1];
            int dx = x+delta_x, dy = y+delta_y;
            if(Common.isInHome(dx, dy, color) && board.getColor(dx, dy)!=color)
                locs.add(Common.encoder(dx, dy));
                
        }
        return locs;
    }
}