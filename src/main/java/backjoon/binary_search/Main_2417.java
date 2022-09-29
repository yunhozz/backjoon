package backjoon.binary_search;

import java.util.Scanner;

public class Main_2417 {

    static long n, ans = Long.MAX_VALUE;

    static void func(long start, long end) {
        if (start > end) {
            return;
        }
        long mid = (start + end) / 2;
        long result = (long) Math.pow(mid, 2); // 제곱

        if (result >= n) {
            ans = Math.min(ans, mid);
            func(start, mid - 1);
        } else {
            func(mid + 1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();

        func(0, n);
        System.out.println(ans);
    }
}