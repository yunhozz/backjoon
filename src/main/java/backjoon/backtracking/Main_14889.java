package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14889 {

    static int N, ans;
    static int[] start, link;
    static boolean[] check;
    static int[][] board;

    static void func(int count) {
        if (count == N / 2) {
            int idx = 0;
            for (int i = 0; i < check.length; i++) {
                if (!check[i]) {
                    link[idx++] = i;
                }
            }
            ans = Math.min(ans, cal(start, link));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                start[count] = i;

                if (isBig(count)) {
                    func(count + 1);
                }
                check[i] = false;
            }
        }
    }

    static boolean isBig(int count) {
        if (count == 0) {
            return true;
        }
        return start[count] > start[count - 1];
    }

    static int cal(int[] start, int[] link) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < start.length; i++) {
            for (int j = i; j < start.length; j++) {
                if (i != j) {
                    sum1 += board[start[i]][start[j]] + board[start[j]][start[i]];
                }
            }
        }
        for (int i = 0; i < link.length; i++) {
            for (int j = i; j < link.length; j++) {
                if (i != j) {
                    sum2 += board[link[i]][link[j]] + board[link[j]][link[i]];
                }
            }
        }
        return Math.abs(sum1 - sum2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        board = new int[N][N];
        start = new int[N / 2];
        link = new int[N / 2];
        check = new boolean[N];

        for (int n = 0; n < N; n++) {
            String[] input = br.readLine().split(" ");
            int k = 0;

            for (String s : input) {
                board[n][k] = Integer.parseInt(s);
                k++;
            }
        }
        func(0);
        System.out.println(ans);
    }
}