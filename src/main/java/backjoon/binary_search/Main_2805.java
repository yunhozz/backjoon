package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        int N = Integer.parseInt(input1[0]); // 나무의 수
        long M = Long.parseLong(input1[1]); // 나무의 길이
        long[] arr = new long[N];
        int idx = 0;

        for (String s : input2) {
            arr[idx++] = Long.parseLong(s);
        }
        Arrays.sort(arr);
        long min = 0;
        long max = arr[N - 1];

        while (min <= max) {
            long mid = (min + max) / 2; // 톱의 높이
            long sum = 0;

            for (long l : arr) {
                if (l > mid) {
                    sum += (l - mid);
                }
            }
            if (sum < M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(max);
    }
}