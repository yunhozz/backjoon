package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14712 {

    static int n, m, ans = 0;
    static boolean[][] check;

    static void func(int x, int y) {
        if (y == m) {
            for (int i = 0; i <= n - 2; i++) {
                for (int j = 0; j <= m - 2; j++) {
                    if (isSquare(i, j)) {
                        return;
                    }
                }
            }

            ans++;
            return;
        }

        int nx = x + 1 == n ? 0 : x + 1;
        int ny = nx == 0 ? y + 1 : y;

        check[x][y] = true;
        func(nx, ny);

        check[x][y] = false;
        func(nx, ny);
    }

    static boolean isSquare(int x, int y) {
        return check[x][y] && check[x+1][y] && check[x][y+1] && check[x+1][y+1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new boolean[n][m];

        func(0, 0);
        System.out.println(ans);
    }
}