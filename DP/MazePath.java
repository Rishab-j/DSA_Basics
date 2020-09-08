package DP;

/**
 * MazePath
 */
public class MazePath {
    
    
    public static int mazePath(int sr,int sc,int dr,int dc){
       int[][] dp = new int[dr][dc];
        for(int i = dp.length-1;i>=0; i--){
            for(int j = dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j == dp[0].length-1){
                    dp[i][j]=1;
                }
                else if(i==dp.length-1){
                    dp[i][j]=dp[i][j+1];

                }
                else if(j==dp[0].length-1){
                    dp[i][j]=dp[i+1][j];
                }
                else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];

                }
            }
            
    }
    return dp[0][0];
    }
    public static void main(String[] args) {
        System.out.println(mazePath(0,0,2,8));
    }
}