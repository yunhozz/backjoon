package backjoon.binary_search;

import java.util.Scanner;

public class Main_2417 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long min = 0;
        long max = n;
        long ans = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            long pow = (long) Math.pow(mid, 2);

            if (pow >= n) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(ans);
    }
}