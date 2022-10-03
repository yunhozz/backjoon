package backjoon.binary_search;

import java.util.Scanner;

public class Main_1789 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        long min = 1;
        long max = S;
        long ans = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = (mid * (mid + 1)) / 2;

            if (sum <= S) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(ans);
    }
}