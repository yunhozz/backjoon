package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int min = 1;
        int max = arr[n-1] - arr[0];
        int ans = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            int start = arr[0];
            int count = 1;

            for (int i = 0; i < n; i++) {
                int gap = arr[i] - start;
                if (gap >= mid) {
                    start = arr[i];
                    count++;
                }
            }

            if (count >= c) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(ans);
    }
}