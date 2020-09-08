package DP;

/**
 * CoinChange
 */
public class CoinChange {

    public static int coinChange(int[] coins , int target){
        int[] dp = new int[target+1];
        for(int i = 0 ; i<dp.length ;i++){ // i is the current target
            for(int j = 0 ; j<coins.length ; j++){
                if(i-coins[j]>=0){
                    if(i-coins[j]==0){ // jbb apna coin exactly target ke equal hoga to wo bhi to count hoga
                        dp[i]=dp[i]+1;
                    }
                    dp[i]=dp[i]+dp[i-coins[j]];
                }
            }
        }
        for(int i = 0 ;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        for(int i:dp){
            System.out.print(i +" ");
        }
        System.out.println();
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] coins = {2,3,5,6};
        int target = 10;
        System.out.println(coinChange(coins,target));
        
    }
}