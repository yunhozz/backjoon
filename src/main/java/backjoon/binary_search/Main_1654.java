package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]); // 원래 랜선의 개수
        int N = Integer.parseInt(input[1]); // 필요한 랜선의 개수
        long[] arr = new long[K];
        int idx = 0;

        for (int k = 0; k < K; k++) {
            arr[idx++] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);
        long min = 1;
        long max = arr[K - 1];

        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;

            for (long n : arr) {
                count += (n / mid);
            }
            if (count < N) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(max);
    }
}