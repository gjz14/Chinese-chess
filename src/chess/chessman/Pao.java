package chess.chessman;

import chess.Piece;

import java.util.ArrayList;
import java.util.List;

import chess.Board;
import chess.Common;

public class Pao extends Piece {
    public Pao(int x, int y, int color) {
        super(x, y, color);
    }

    public String get_img() {
        if (this.color == 1)
            return "img/bp.png";
        else
            return "img/rp.png";
    }



    public List<Integer> getMoveLocations(int x, int y, Board board) {
        List<Integer> locs = new ArrayList<>();
        int []dirs = new int[]{0,1,0,-1,0};
        for(int i=0;i<4;i++){
            // move four directions
            int delta_x = dirs[i];
            int delta_y = dirs[i+1];
            int dx = x+delta_x;
            int dy = y+delta_y;
            // add empty spaces
            while(Common.isInBoard(dx, dy) && board.getColor(dx, dy)==-1){
                locs.add(Common.encoder(dx, dy));
                dx += delta_x;
                dy += delta_y;
            }
            // add a enemy's piece's position
            dx += delta_x;
            dy += delta_y;
            while(Common.isInBoard(dx, dy) && board.getColor(dx, dy)==-1){
                dx += delta_x;
                dy += delta_y;
            }
            if(Common.isInBoard(dx, dy) && board.getColor(dx, dy)!=color)
                locs.add(Common.encoder(dx, dy));
                
        }
        return locs;
    }
}