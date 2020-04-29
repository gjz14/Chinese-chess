package chess.chessman;

import chess.Piece;

import java.util.ArrayList;
import java.util.List;

import chess.Board;
import chess.Common;

public class Shi extends Piece {
    public Shi(int x, int y, int color) {
        super(x, y, color);
    }

    public String get_img() {
        if (this.color == 1)
            return "img/bs.png";
        else
            return "img/rs.png";
    }

    public boolean move(int dx, int dy, Board board) {
        return true;
    }

    public List<Integer> getMoveLocations(int x, int y, Board board) {
        List<Integer> res = new ArrayList<>();
        return res;
    }
}