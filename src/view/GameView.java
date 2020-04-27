package view;

import chess.Board;
import chess.Piece;
import chess.Common;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameView{
    private static final int VIEW_WIDTH = 700, VIEW_HEIGHT = 712;
    private static final int PIECE_WIDTH = 67, PIECE_HEIGHT = 67;
    private static final int SY_COE = 68, SX_COE = 68;
    private static final int SX_OFFSET = 50, SY_OFFSET = 15;
    private Board board;
    private JFrame frame;
    private JLayeredPane pane;
    public void draw_board(Board board){
        // draw the board background
        this.board = board;
        frame = new JFrame("Chinese Chess");
        frame.setIconImage(new ImageIcon("img/icon.png").getImage());
        frame.setSize(VIEW_WIDTH, VIEW_HEIGHT + 40);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pane = new JLayeredPane();
        frame.add(pane);

        /* Initialize chess board and listeners on each slot.*/
        JLabel bgBoard = new JLabel(new ImageIcon("img/board.png"));
        bgBoard.setLocation(0, 0);
        bgBoard.setSize(VIEW_WIDTH, VIEW_HEIGHT);
        bgBoard.addMouseListener(new BoardClickListener());
        pane.add(bgBoard, 1);

        Map<Integer,Piece> pieces = board.pieces;
        for (Map.Entry<Integer, Piece> PieceEntry : pieces.entrySet()) {
            int pos = PieceEntry.getKey();
            String image= PieceEntry.getValue().get_img();
            
            JLabel lblPiece = new JLabel(new ImageIcon(image));

            int []viewpos = modelToViewConverter(Common.decoder(pos));
            lblPiece.setLocation(viewpos[0],viewpos[1]);
            lblPiece.setSize(PIECE_WIDTH, PIECE_HEIGHT);
            lblPiece.addMouseListener(new PieceOnClickListener(pos));
            pane.add(lblPiece, 0);
        }

        

        frame.setVisible(true);
    }



    private int[] modelToViewConverter(int pos[]) {
        int sx = pos[1] * SX_COE + SX_OFFSET, sy = pos[0] * SY_COE + SY_OFFSET;
        return new int[]{sx, sy};
    }

    private int[] viewToModelConverter(int sPos[]) {
        /* To make things right, I have to put an 'additional sy offset'. God knows why. */
        int ADDITIONAL_SY_OFFSET = 25;
        int y = (sPos[0] - SX_OFFSET) / SX_COE, x = (sPos[1] - SY_OFFSET - ADDITIONAL_SY_OFFSET) / SY_COE;
        return new int[]{x, y};
    }

    class PieceOnClickListener extends MouseAdapter {
        private int pos;
        PieceOnClickListener(int key) {
            this.pos = key;
        }
        @Override
        public void mousePressed(MouseEvent e) {        
                int x = board.pieces.get(pos).x;
                int y = board.pieces.get(pos).y;
                board.select(x, y);       
        }
    }

    class BoardClickListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            int[] sPos = new int[]{e.getXOnScreen() - frame.getX(), e.getYOnScreen() - frame.getY()};
            int[] pos = viewToModelConverter(sPos);
            board.move(pos[0],pos[1]); 
            draw_board(board);
        }
    }

}
