package DP;

/**
 * knapsack
 */
public class knapsack {
    public static int knapsack(int[] weight, int[] value, int capacity) {
        int[][] dp = new int[weight.length + 1][capacity + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weight[i - 1] >= 0) {
                    if (dp[i][j] < (value[i - 1] + dp[i - 1][j - weight[i - 1]])) {
                        dp[i][j] = value[i - 1] + dp[i - 1][j - weight[i - 1]];
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        int[] weight = { 2, 5, 1, 3, 4, 2, 3 };
        int[] value = { 15, 10, 25, 15, 50, 75, 25 };
        int capacity = 7;
        System.out.println(knapsack(weight, value, capacity));
    }
}