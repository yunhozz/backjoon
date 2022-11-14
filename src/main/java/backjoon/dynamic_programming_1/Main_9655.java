package backjoon.dynamic_programming_1;

import java.util.Scanner;

public class Main_9655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] dp = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (!dp[i - 1]) {
                dp[i] = true;
            }

            if (i - 3 >= 0 && !dp[i - 3]) {
                dp[i] = true;
            }
        }

        if (dp[N]) {
            System.out.println("SK");

        } else {
            System.out.println("CY");
        }
    }
}