package chess.chessman;

import chess.Piece;

import java.util.ArrayList;
import java.util.List;

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

    
    public List<Integer> getMoveLocations(int x,int y, Board board){
        List<Integer> locs = new ArrayList<>();
        // black bing
        if(color==1){
            // can move forward
            if( x!=9 && board.getColor(x+1,y)!=1)
                locs.add(Common.encoder(x+1, y));
            
            // can move left
            if( y>0 && x>4 && board.getColor(x,y-1)!=1)
                locs.add(Common.encoder(x, y-1));
            
            // can move right
            if( y<8 && x>4 && board.getColor(x,y+1)!=1) 
                locs.add(Common.encoder(x, y+1));

        }
        else{
            // can move forward 
            if(x>0 && board.getColor(x-1,y)!=0)
                locs.add(Common.encoder(x-1, y));
            
            // can move left
            if( y>0 && x<5 && board.getColor(x,y-1)!=0)
                locs.add(Common.encoder(x, y-1));

            // can move right

            if( y<8 && x<5 && board.getColor(x,y+1)!=0)
                locs.add(Common.encoder(x, y+1));  
        }
        return locs;
    }

}