package DP;


import java.util.*;

public class MinCost {
    public static int minCost(int[][] arr,int sr ,int sc ,int er ,int ec){
        int[][] dp = new int[er][ec];
        for(int i=dp.length-1;i>=0; i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j]=arr[i][j];
                }
                else if( i == dp.length - 1){
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                }
                else if(j == dp[0].length-1){
                    dp[i][j]= arr[i][j] + dp[i+1][j];
                }
                else{
                    
                        int min1 = Math.min(arr[i][j] + dp[i+1][j+1],arr[i][j] + dp[i][j+1]);
                        int min2 = Math.min(min1,arr[i][j] + dp[i+1][j]);
                        dp[i][j] = min2;
                   
                        
                    }
                }
            }
        
        return dp[0][0];
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] arr = new int[r][c];
        for(int i = 0; i < r ; i++ ){
            for(int j = 0 ; j < c ; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println(minCost(arr, 0, 0,r,c));
    }
}