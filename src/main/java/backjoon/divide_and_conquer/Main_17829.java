package backjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17829 {

    static int[][] board;

    static int func(int x, int y, int n) {
        int[] arr = new int[4];

        if (n == 2) {
            int idx = 0;

            for (int i = x; i < x + 2; i++) {
                for (int j = y; j < y + 2; j++) {
                    arr[idx++] = board[i][j];
                }
            }

            Arrays.sort(arr);
            return arr[2];
        }

        arr[0] = func(x , y, n/2);
        arr[1] = func(x + n/2, y, n/2);
        arr[2] = func(x, y + n/2, n/2);
        arr[3] = func(x + n/2, y + n/2, n/2);

        Arrays.sort(arr);
        return arr[2];
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

        System.out.println(func(0, 0, n));
    }
}