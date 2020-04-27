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
}