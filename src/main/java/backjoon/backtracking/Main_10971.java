package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10971 {

    static int N, ans;
    static int[] arr;
    static int[][] W;
    static boolean[] isCheck;

    static void func(int idx) {
        if (idx == N) {
            int sum = 0;
            boolean flag = true;

            for (int i = 0; i < arr.length - 1; i++) {
                int w = W[arr[i]][arr[i + 1]];
                if (w == 0) {
                    flag = false;
                    break;
                }
                sum += w;
            }
            if (flag) {
                int w = W[arr[arr.length - 1]][arr[0]];
                if (w != 0) {
                    sum += w;
                    ans = Math.min(ans, sum);
                }
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isCheck[i]) {
                isCheck[i] = true;
                arr[idx] = i;
                func(idx + 1);
                isCheck[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        arr = new int[N];
        ans = Integer.MAX_VALUE;
        isCheck = new boolean[N];

        for (int n = 0; n < N; n++) {
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                W[n][i] = Integer.parseInt(input[i]);
            }
        }
        func(0);
        System.out.println(ans);
    }
}