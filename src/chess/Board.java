package chess;

import chess.Piece;
import chess.Common;
import chess.chessman.*;

import java.util.HashMap;
import java.util.Map;

public class Board {

    public Map<Integer,Piece> pieces = new HashMap<>();
    public Piece selected_piece;

    //init
    public Board(){
        // init black pieces
        pieces.put(Common.encoder(3,0),new Bing(3,0,1));
        pieces.put(Common.encoder(3,2),new Bing(3,2,1));
        pieces.put(Common.encoder(3,4),new Bing(3,4,1));
        pieces.put(Common.encoder(3,6),new Bing(3,6,1));
        pieces.put(Common.encoder(3,8),new Bing(3,8,1));

        pieces.put(Common.encoder(0,0),new Che(0,0,1));
        pieces.put(Common.encoder(0,8),new Che(0,8,1));

        pieces.put(Common.encoder(0,1),new Ma(0,1,1));
        pieces.put(Common.encoder(0,7),new Ma(0,7,1));

        pieces.put(Common.encoder(0,6),new Xiang(0,6,1));
        pieces.put(Common.encoder(0,2),new Xiang(0,2,1));

        pieces.put(Common.encoder(0,3),new Shi(0,3,1));
        pieces.put(Common.encoder(0,5),new Shi(0,5,1));

        pieces.put(Common.encoder(2,1),new Pao(2,1,1));
        pieces.put(Common.encoder(2,7),new Pao(2,7,1));

        pieces.put(Common.encoder(0,4),new Shuai(0,4,1));

        //init red pieces
        pieces.put(Common.encoder(6,0),new Bing(6,0,0));
        pieces.put(Common.encoder(6,2),new Bing(6,2,0));
        pieces.put(Common.encoder(6,4),new Bing(6,4,0));
        pieces.put(Common.encoder(6,6),new Bing(6,6,0));
        pieces.put(Common.encoder(6,8),new Bing(6,8,0));

        pieces.put(Common.encoder(9,0),new Che(9,0,0));
        pieces.put(Common.encoder(9,8),new Che(9,8,0));

        pieces.put(Common.encoder(9,1),new Ma(9,1,0));
        pieces.put(Common.encoder(9,7),new Ma(9,7,0));

        pieces.put(Common.encoder(9,6),new Xiang(9,6,0));
        pieces.put(Common.encoder(9,2),new Xiang(9,2,0));

        pieces.put(Common.encoder(9,3),new Shi(9,3,0));
        pieces.put(Common.encoder(9,5),new Shi(9,5,0));

        pieces.put(Common.encoder(7,1),new Pao(7,1,0));
        pieces.put(Common.encoder(7,7),new Pao(7,7,0));

        pieces.put(Common.encoder(9,4),new Shuai(9,4,0));

    }

    public void move(int dx, int dy){
        // if there is no selected piece
        if(selected_piece==null)
            return;
        else{
            try{
                selected_piece.move(dx,dy,this);
            } catch(Exception e){
                System.out.println("Error when moving a piece");
            }        
            selected_piece = null; // after move, unselect
        }
    }
    public void remove(int x,int y){
        int pos = Common.encoder(x, y);
        try{
            pieces.remove(pos);
        } catch(Exception e){
            System.out.println("Error in removing a piece");
        }
    }
    
    public void select(int x,int y){
        int key  = Common.encoder(x, y);
        if(pieces.containsKey(key)){
            selected_piece = pieces.get(key);
            System.out.println(selected_piece);
        }
    }
    
}