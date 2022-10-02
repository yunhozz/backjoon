package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 지방의 수
        String[] input = br.readLine().split(" "); // 각 지방의 예산 요청
        long M = Integer.parseInt(br.readLine()); // 총 예산

        int[] arr = new int[N];
        int idx = 0;

        for (String s : input) {
            arr[idx++] = Integer.parseInt(s);
        }

        Arrays.sort(arr);
        int min = 0;
        int max = arr[N - 1] + 1;

        while (min < max) {
            int mid = (min + max) / 2;
            int sum = 0;

            for (int n : arr) {
                sum += Math.min(n, mid);
            }

            if (sum > M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}