package backjoon.dynamic_programming_1;

import java.util.Scanner;

public class Main_2839 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        dp[3] = 1;

        if (N > 4) {
            dp[5] = 1;
        }

        for (int n = 6; n <= N; n++) {
            if (n % 5 == 0) {
                dp[n] = dp[n - 5] + 1;

            } else if (n % 3 == 0) {
                dp[n] = dp[n - 3] + 1;

            } else {
                if (dp[n - 3] != 0 && dp[n - 5] != 0) {
                    dp[n] = Math.min(dp[n - 3], dp[n - 5]) + 1;
                }
            }
        }

        if (dp[N] != 0) {
            System.out.println(dp[N]);

        } else {
            System.out.println(-1);
        }
    }
}