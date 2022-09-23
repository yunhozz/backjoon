package backjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3085 {

    private static int N;
    private static char[][] board;
    private static int ans = 0;

    private static void check() {
        // 가로줄 체크
        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                } else {
                    count = 1;
                }
                ans = Math.max(ans, count);
            }
        }
        // 세로줄 체크
        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j+1][i]) {
                    count++;
                } else {
                    count = 1;
                }
                ans = Math.max(ans, count);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        // 가로줄 조작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                char temp = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = temp;

                check();

                temp = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = temp;
            }
        }
        // 세로줄 조작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                char temp = board[j][i];
                board[j][i] = board[j+1][i];
                board[j+1][i] = temp;

                check();

                temp = board[j][i];
                board[j][i] = board[j+1][i];
                board[j+1][i] = temp;
            }
        }
        System.out.println(ans);
    }
}