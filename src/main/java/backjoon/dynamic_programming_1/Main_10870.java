package backjoon.dynamic_programming_1;

import java.util.Scanner;

public class Main_10870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 2];

        dp[0] = 0;
        dp[1] = 1;
        int count = 2;

        while (count <= n) {
            dp[count] = dp[count-1] + dp[count-2];
            count++;
        }
        System.out.println(dp[n]);
    }
}