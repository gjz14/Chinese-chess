package chess;

import java.util.ArrayList;
import java.util.List;

import chess.Board;
import chess.Common;
import chess.chessman.Shuai;

abstract public class Piece {
    public int x;
    public int y;
    public int color; // 0 for red, 1 for black
    public Piece(int x,int y,int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public boolean canMoveWithoutFaceKing(int x, int y, Board board){
        int upx = x-1, downx = 1+x;
        while(Common.isInBoard(upx, y) && board.getColor(upx, y)==-1)
            upx--;
        while(Common.isInBoard(downx, y) && board.getColor(downx, y)==-1)
            downx++;
        if(Common.isInBoard(upx, y) && Common.isInBoard(downx, y)){
            if(board.pieces.get(Common.encoder(upx, y)).getClass() == Shuai.class && board.pieces.get(Common.encoder(downx, y)).getClass() == Shuai.class)
                return false;
        }
        return true;
    }
    
    public boolean move(int dx, int dy, Board board){
        List<Integer> canMoves = getMoveLocations(x, y, board);
        int pos = Common.encoder(dx, dy);
        if(!canMoves.contains(pos) || !canMoveWithoutFaceKing(x,y,board))
            return false;
        // reomve the piece from its original position
        board.remove(x, y);
        this.x = dx;
        this.y = dy;
        // eat
        board.remove(dx, dy);
        // move to the destination
        board.pieces.put(Common.encoder(x, y), this);
        return true;
    };

    abstract public String get_img();

    abstract public List<Integer> getMoveLocations(int x,int y, Board board);

}


