package backjoon.binary_search;

import java.util.Scanner;

public class Main_1789 {

    static long S, ans = 0;

    static void func(long start, long end) {
        if (start > end) {
            return;
        }
        long mid = (start + end) / 2;
        long sum = (mid * (mid + 1)) / 2; // 1 ~ mid 까지 총 합

        if (sum > S) {
            func(start, mid - 1);
        }
        else if (sum < S) {
            ans = Math.max(ans, mid);
            func(mid + 1, end);
        }
        else {
            ans = mid;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLong();

        func(1, S);
        System.out.println(ans);
    }
}