package backjoon.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3079 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]); // 심사대 개수
        long M = Integer.parseInt(input[1]); // 인원수

        long[] time = new long[N];

        for (int n = 0; n < N; n++) {
            time[n] = sc.nextLong();
        }
        Arrays.sort(time);
        long min = 0;
        long max = time[N - 1] * M;

        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0; // 가능한 총 인원수

            for (long t : time) {
                sum += (mid / t);
            }
            if (sum >= M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }
}