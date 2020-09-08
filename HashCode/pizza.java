package HashCode;

import java.util.Scanner;

/**
 * pizza
 */
public class pizza {

    public static void typesofpizza(int capacity, int[] slices, int[] value) {
        int[][] dp = new int[slices.length + 1][capacity + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j - slices[i - 1] >= 0) {
                    if (dp[i][j] < (value[i - 1] + dp[i - 1][j - slices[i - 1]])) {
                        dp[i][j] = value[i - 1] + dp[i - 1][j - slices[i - 1]];
                    }
                }
            }
        }

        int ans = dp[slices.length - 1][capacity - 1];
        System.out.println(ans);

        int cap = capacity;
        for (int i = dp.length - 1; i > 0 && ans > 0; i--) {

            if (cap >= slices[i - 1]) {
                if (ans == dp[i - 1][cap] && ans == (value[i - 1] + dp[i - 1][cap - slices[i - 1]])) {
                    System.out.print(slices[i - 1] + " ");
                    ans = ans - value[i - 1];
                    cap = cap - slices[i - 1];

                } else {

                    System.out.print(slices[i - 1] + " ");

                    ans = ans - value[i - 1];
                    cap = cap - slices[i - 1];

                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int capacity;
        System.out.println("Enter capacity : ");
        capacity = scn.nextInt();
        System.out.println("Enter no. of pizza");
        int pizza = scn.nextInt();
        int slices[] = new int[pizza];
        for (int i = 0; i < pizza; i++) {
            slices[i] = scn.nextInt();
        }
        for (int i = 0; i < pizza; i++) {
            System.out.print(slices[i] + " ");
        }
        System.out.println();
        int[] value = new int[pizza];
        for (int i = 0; i < pizza; i++) {
            value[i] = 1;
        }
        for (int i = 0; i < pizza; i++) {
            System.out.print(value[i] + " ");
        }
        System.out.println();
        typesofpizza(capacity, slices, value);
    }
}