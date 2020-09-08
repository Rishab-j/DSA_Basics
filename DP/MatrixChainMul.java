package DP;

public class MatrixChainMul {

    public static int mcmm(int[] arr,int si,int ei,int[][] dp){
        if(ei-si==1){
            return 0;
        }

        if(dp[si][ei]!=0){
            return dp[si][ei];
        }
         int min = Integer.MAX_VALUE;
        for(int bp = si+1;bp<ei;bp++){
            int mcm1 = mcmm(arr, si, bp, dp);
            int mcm2 = mcmm(arr, bp, ei, dp);

            int product = arr[si]*arr[bp]*arr[ei];
            int sum = mcm1+mcm2+product;

            if(min>sum){
                min = sum; 
            }
        }
        
        dp[si][ei]=min;
        return min;
    }


    public static int mcmt(int[] arr,int si,int ei){

        int[][] dp = new int[arr.length-1][arr.length-1];
        
        for(int gap =0;gap<dp.length;gap++){
            int i = 0;
            int j = i+gap;
        
            while(j<dp.length){
                
                if(gap==0){
                    dp[i][j]=0;
                }
                else if(gap==1){
                    dp[i][j]=arr[i]*arr[j+1]*arr[j];
                }
                else{
                    int min = Integer.MAX_VALUE;
                    for(int cp=i;cp<j;cp++){
                        int p1 = dp[i][cp];
                        int p2 = dp[cp+1][j];
                        int product = arr[i]*arr[cp+1]*arr[j+1];
                        int factor = p1 + p2 + product;
                        if(factor<min){
                            min = factor;
                        }
                        dp[i][j]=min;
                    }

                }


                i++;
                j++;
            }
        }
        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        return dp[0][dp.length-1];
    }
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60};
        System.out.println(mcmm(arr, 0, arr.length-1, new int[arr.length][arr.length]));
        System.out.println(mcmt(arr, 0, arr.length-1));
    }
}