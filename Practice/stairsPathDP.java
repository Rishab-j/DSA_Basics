package Practice;

import java.util.*;

public class stairsPathDP{
    public static int stairsPathSir(final int n) {
        final int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int myans = 0;
            if (i - 1 >= 0) {
                myans += dp[i - 1];
            }
            if (i - 2 >= 0) {
                myans += dp[i - 2];
            }
            if (i - 3 >= 0) {
                myans += dp[i - 3];
            }
            dp[i] = myans;
        }
        return dp[n];
    }

    public static int stairsPath(final int n) {
        final int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (i - 1 == 0) {
                dp[i] = dp[i - 1];
            } else if (i - 2 == 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

    public static void main(final String[] args) {
        final Scanner scn = new Scanner(System.in);
        final int n = scn.nextInt();
    //System.out.print(stairsPath(n));
    System.out.print(stairsPathSir(n));
}
}