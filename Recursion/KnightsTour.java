package Recursion;

/**
 * KnightsTour
 */
public class KnightsTour {

    public static void knightsTour(boolean[][] chess ,int[][] moves, int move ,int row, int col){
       // for(int i=0;i<chess.length*chess.length;i++){
        //    int row = i/chess.length;
           // int col = i%chess.length;

           // if(knight)
       // }
       if(move == 16){
           for(int i = 0;i<4;i++){
               for(int j = 0;j<4;j++){
                   System.out.print(moves[i][j] + " ");
               }
               System.out.println();
           }

       }
        

        
       chess[row][col]=true;     
       if((row + 2)<chess.length && (col+1)<chess[0].length && chess[row+2][col+1]==false){
        moves[row][col]=move;   
        knightsTour(chess,moves, move+1, row+2, col+1);
       }
       if((row + 1)<chess.length && (col+2)<chess[0].length && chess[row+1][col+2]==false){
        moves[row][col]=move;
        knightsTour(chess,moves, move+1, row+1, col+2);
        }
        if((row + 2)<chess.length && (col-1)>=0 && chess[row+2][col-1]==false){
            moves[row][col]=move;
            knightsTour(chess,moves, move+1, row+2, col-1);
        }
        if((row + 1)<chess.length && (col-2)>=0 && chess[row+1][col-2]==false){
            moves[row][col]=move;
            knightsTour(chess,moves, move+1, row+1, col-2);
        }
        if((row - 2)>=0 && (col+1)<chess[0].length && chess[row-2][col+1]==false){
            moves[row][col]=move; 
            knightsTour(chess,moves, move+1, row-2, col+1);
        }
        if((row - 1)>=0 && (col+2)<chess[0].length && chess[row-1][col+2]==false){
            moves[row][col]=move;
            knightsTour(chess,moves, move+1, row-1, col+2);
        }
        if((row - 2)>=0 && (col-1)>=0 && chess[row-2][col-1]==false){
            moves[row][col]=move;
            knightsTour(chess,moves, move+1, row-2, col-1);
        }
        if((row-1)>=0 && (col-2)>=0 && chess[row-1][col-2]==false){
            moves[row][col]=move; 
            knightsTour(chess,moves, move+1, row-1, col-2);
        }
        chess[row][col]=false;
       
        
    }

    public static void main(String[] args) {
        boolean[][] chess = new boolean[4][4];
        int[][] moves = new int[chess.length][chess[0].length];
        knightsTour(chess, moves, 1, 1, 1);
        
    }
}