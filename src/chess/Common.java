package chess;

public class Common {
    public static int[] decoder(int pos){
        int [] res = new int[2];
        res[0] = pos/9;
        res[1] = pos%9;
        return res;
    }
    public static int encoder(int x,int y){
        return x*9+y;
    }
    public static boolean isInBoard(int x,int y){
        if(x>=0 && x<10 && y>=0 && y<9)
            return true;
        return false;
    }
    public static boolean isInPalace(int x,int y, int color){
        // red
        if(color==0)
            return (x>=7 && x<=9 && y>=3 && y<=5);
        // black
        return (x>=0 && x<=2 && y>=3 && y<=5);
    }
    public static boolean isInHome(int x,int y, int color){
        //red 
        if(color==0)
            return (x<10 && x>=5 && y>=0 && y<9);
        return (x>=0 && x<=4 && y>=0 && y<9);
    }
}