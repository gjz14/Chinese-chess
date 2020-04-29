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


    public List<Integer> getMoveLocations(int x, int y, Board board) {
        List<Integer> locs = new ArrayList<>();
        int dirs[] = new int[]{0,1,0,-1,0};
        for(int i=0;i<4;i++){
            int delta_x = dirs[i], delta_y = dirs[i+1];
            int dx = x+delta_x, dy = y+delta_y;
            if(Common.isInPalace(dx, dy, color) && board.getColor(dx, dy)!=color)
                locs.add(Common.encoder(dx, dy));
        }
        return locs;
    }
}