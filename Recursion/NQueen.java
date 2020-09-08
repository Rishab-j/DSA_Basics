package Recursion;

/**
 * NQueen
 */
public class NQueen {

    public static void nqueen(boolean[][] chess,int qp,int lqi,String asf){
        if(qp==chess.length){
            System.out.println(asf);
        }
        for(int b = lqi+1; b<chess.length*chess.length; b++){
            int row = b/chess.length;
            int col = b%chess.length;
            if(chess[row][col]==false){
                
                if(queenIsSafe(chess,row,col)==true){
                    chess[row][col]=true;
                    nqueen(chess, qp+1, b, asf + "q" + (qp+1) +"b"+b + " ");
                    chess[row][col]=false;
                }
            }
        }

    }

    private static boolean queenIsSafe(boolean[][] chess, int row, int col) {
        int[][] dir={
            {0,-1},
            {1,-1},
            {1,0},
            {1,1},
            {0,1},
            {-1,1},
            {-1,0},
            {-1,-1}
        };
        for(int di=0;di<dir.length;di++){
            for(int dis=1;true;dis++){
                int erow = row + dis*dir[di][1];
                int ecol = col + dis*dir[di][0];

                if(erow < 0 || ecol < 0 || erow>=chess[0].length || ecol>=chess.length){
                    break ;
                }

                if(chess[erow][ecol]==true){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[][] chess = new boolean[4][4];
        nqueen(chess, 0, -1, "");
        
    }
}