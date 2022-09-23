package backjoon.brute_force;

import java.util.Scanner;

public class Main_1748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = 1;
        int count = 0;
        int ans = 0;

        for (int n = 1; n <= N; n++) {
            if (n % r == 0) {
                count++;
                r *= 10;
            }
            ans += count;
        }
        System.out.println(ans);
    }
}