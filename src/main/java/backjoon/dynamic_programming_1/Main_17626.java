package backjoon.dynamic_programming_1;

import java.util.Scanner;

public class Main_17626 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        int min = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }

            dp[i] = min + 1;
        }

        System.out.println(dp[n]);
    }
}