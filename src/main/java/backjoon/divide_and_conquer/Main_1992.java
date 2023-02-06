package backjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992 {

    static int[][] picture;
    static StringBuilder sb = new StringBuilder();

    static void func(int x, int y, int size) {
        if (checkMono(x, y, size)) {
            sb.append(picture[x][y]);
            return;
        }

        sb.append("(");
        func(x, y, size / 2);
        func(x, y + size / 2, size / 2);
        func(x + size / 2, y, size / 2);
        func(x + size / 2, y + size / 2, size / 2);
        sb.append(")");
    }

    static boolean checkMono(int x, int y, int size) {
        int color = picture[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (picture[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        picture = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            int idx = 0;

            for (String s : input) {
                picture[i][idx++] = Integer.parseInt(s);
            }
        }

        func(0, 0, n);
        System.out.println(sb);
    }
}