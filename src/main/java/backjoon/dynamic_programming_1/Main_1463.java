package backjoon.dynamic_programming_1;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1463 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        Arrays.fill(dp, 2, N + 1, 1);

        for (int i = 4; i <= N; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i / 2] + 1);

            } else {
                if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);

                } else if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);

                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        }

        System.out.println(dp[N]);
    }
}