package DP;

/**
 * MaxSizeSquareSubMatrix
 */



                          // MUST SEE HOW TO DO WITH RECURSION AND MEMOIZATION
 
 

public class MaxSizeSquareSubMatrix {

    public static void maxSquare(int[][] arr){
        int max = 0;
        int mrow = -1;
        int mcol = -1;
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(arr[i][j]==0){
                    dp[i][j] = 0;
                }
                else if(j==dp[0].length-1){
                    dp[i][j]=arr[i][j];

                }
                else if(i==dp.length-1){
                    dp[i][j]=arr[i][j];
                }
                else{
                    int min1 = Math.min(dp[i+1][j], dp[i+1][j+1]);
                    int min2 = Math.min(min1,dp[i][j+1]);
                    dp[i][j] = 1+min2;
                }
                if(dp[i][j]>max){
                    max=dp[i][j];
                    mrow = i;
                    mcol = j;
                }
            }
        }
        for(int i =0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        } 
        System.out.println(max + "{" +mrow +"," + mcol + "}");
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1,0,1,0,0,1},
            {1,0,1,1,1,1},
            {1,1,1,1,1,1},
            {1,1,1,1,0,0},
            {1,1,1,1,1,1},
            {0,0,1,1,1,0}
        };
// 39
        maxSquare(arr);

    }
}