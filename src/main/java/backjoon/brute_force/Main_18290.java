package backjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_18290 {

    static int[][] board;
    static boolean[][] check;
    static int N, M, K, ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void func(int n, int m, int count, int sum) {
        if (count == K) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = n; i < N; i++) {
            for (int j = m; j < M; j++) {
                if (!check[i][j]) {
                    if (valid(i, j)) {
                        check[i][j] = true;
                        func(n, m, count + 1, sum + board[i][j]);
                        check[i][j] = false;
                    }
                }
            }
        }
    }

    static boolean valid(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (check[nx][ny]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 세로
        M = Integer.parseInt(input[1]); // 가로
        K = Integer.parseInt(input[2]); // 선택하는 수
        board = new int[N][M];
        check = new boolean[N][M];
        ans = Integer.MIN_VALUE;

        for (int n = 0; n < N; n++) {
            String[] arr = br.readLine().split(" ");
            for (int m = 0; m < M; m++) {
                board[n][m] = Integer.parseInt(arr[m]);
            }
        }
        func(0, 0, 0, 0);
        System.out.println(ans);
    }
}