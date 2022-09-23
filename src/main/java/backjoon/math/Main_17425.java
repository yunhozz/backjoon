package backjoon.math;

import java.util.Scanner;

public class Main_17425 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();
            long ans = 0;

            for (int n = 1; n <= num; n++) {
                ans += (long) n * (num / n);
            }
            System.out.println(ans);
        }
    }
}