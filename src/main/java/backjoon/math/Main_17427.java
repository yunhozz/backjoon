package backjoon.math;

import java.util.Scanner;

public class Main_17427 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long ans = 0;

        for (int n = 1; n <= num; n++) {
            ans += (long) n * (num / n);
        }
        System.out.println(ans);
    }
}
