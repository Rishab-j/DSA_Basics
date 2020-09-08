package DP;

/**
 * GoldMine
 */



                       // FOR PRINTING PATH WATCH THE VIDEO AGAIN
public class GoldMine {
    public static void goldMine(int[][] mine){
        int[][] dp = new int[mine.length][mine[0].length];
        int max=0;
        for(int j=dp[0].length-1;j>=0;j--){
            for(int i=dp.length-1;i>=0;i--){
                if(j==mine[0].length-1){
                    dp[i][j]=mine[i][j];
                    
                }
                else if(i==dp.length-1){
                    int max1 = Math.max(mine[i][j]+dp[i-1][j+1], mine[i][j]+dp[i][j+1]);
                    dp[i][j]=max1;

                }
                else if(i==0){
                    int max1 = Math.max(mine[i][j]+dp[i+1][j+1], mine[i][j]+dp[i][j+1]);
                    dp[i][j]=max1;
                }
                else{
                    int max1 = Math.max(mine[i][j]+dp[i-1][j+1], mine[i][j]+dp[i][j+1]);
                    int max2 = Math.max(max1,mine[i][j]+dp[i+1][j+1] );
                    dp[i][j]=max2;
                }
                if(max<=dp[i][j]){
                    max = dp[i][j];
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[][] mine = {
            {2,6,0,5},
            {0,7,5,2},
            {3,0,3,7},
            {8,0,2,3}
        };
        goldMine(mine);
        
    }
}