package backjoon.divide_and_conquer;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2447 {

    static char[][] ans;

    static void func(int size, int x, int y) {
        if (size == 1) {
            ans[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) {
                    func(newSize, x + i * newSize, y + j * newSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        ans = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], ' ');
        }

        func(n, 0, 0);
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb);
    }
}