package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11663 {

    static int N, M;
    static long[] spot;

    static int func(int x, int y) {
        int min = 0;
        int max = spot.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (spot[mid] < x) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        int start = min;
        min = 0;
        max = spot.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (spot[mid] > y) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        int end = max + 1;

        return end - start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        N = Integer.parseInt(num[0]); // 점의 개수
        M = Integer.parseInt(num[1]); // 선분의 개수

        String[] input1 = br.readLine().split(" ");
        spot = new long[N];
        int idx = 0;

        for (String s : input1) {
            spot[idx++] = Long.parseLong(s);
        }
        Arrays.sort(spot);

        for (int m = 0; m < M; m++) {
            String[] input2 = br.readLine().split(" ");
            System.out.println(func(Integer.parseInt(input2[0]), Integer.parseInt(input2[1])));
        }
    }
}