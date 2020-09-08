package LeetCode;

public class UncrossedLine {
    public int maxUncrossedLines(int[] A, int[] B) {
        
        int len1 = A.length;
        int len2 = B.length;
        
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++){
            for(int j = 0;j<=len2;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(A[i-1]==B[j-1]){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}