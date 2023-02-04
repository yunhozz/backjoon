package backjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2630 {

    static int[][] board;
    static int white = 0, blue = 0;

    static void func(int x, int y, int n) {
        if (check(x, y, n)) {
            if (board[x][y] == 0) white++;
            else blue++;
            return;
        }

        func(x, y, n/2);
        func(x + n/2, y, n/2);
        func(x, y + n/2, n/2);
        func(x + n/2, y + n/2, n/2);
    }

    static boolean check(int x, int y, int n) {
        int color = board[x][y];

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int idx = 0;

            for (String s : input) {
                board[i][idx++] = Integer.parseInt(s);
            }
        }

        func(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }
}