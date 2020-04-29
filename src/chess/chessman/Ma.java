package chess.chessman;

import chess.Piece;

import java.util.ArrayList;
import java.util.List;

import chess.Board;
import chess.Common;

public class Ma extends Piece {
    public Ma(int x, int y, int color) {
        super(x, y, color);
    }

    public String get_img() {
        if (this.color == 1)
            return "img/bm.png";
        else
            return "img/rm.png";
    }


    public List<Integer> getMoveLocations(int x, int y, Board board) {
        List<Integer> locs = new ArrayList<>();
        int dirs[] = new int[]{-2,-1,2,-1,-2,1,2,1,-2};
        for(int i=0;i<8;i++){
            int delta_x = dirs[i], delta_y = dirs[i+1];
            // the positions of possible destinations
            int dx = x+delta_x, dy = y+delta_y;

            // the postion of block of horse
            int block_x =  (i%2==0?delta_x>>1:0) + x, block_y = (i%2==1?delta_y>>1:0) + y;
            

            if(Common.isInBoard(dx, dy) && board.getColor(dx,dy)!=color ){
                // the block is out of board or is empty
                if(!Common.isInBoard(block_x, block_y))
                    locs.add(Common.encoder(dx, dy));
                else if(board.getColor(block_x,block_y)==-1)
                    locs.add(Common.encoder(dx, dy));
            }
                
        }
        
        return locs;
    }
}