package backjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {

    static int n, m;
    static int min = Integer.MAX_VALUE;
    static int[][] miro;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 시간초과
    static void dfs(int x, int y, int count) {
        if (x == n - 1 && y == m - 1) {
            min = Math.min(min, count);
            return;
        }

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (miro[nx][ny] != 0 && !visit[nx][ny]) {
                visit[nx][ny] = true;
                dfs(nx, ny, count + 1);
                visit[nx][ny] = false;
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (miro[nx][ny] != 0 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                    miro[nx][ny] = miro[now[0]][now[1]] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            int idx = 0;

            for (String s : input) {
                int num = Integer.parseInt(s);
                miro[i][idx] = num;
                idx++;
            }
        }

//        dfs(0, 0, 1);
//        System.out.println(min);

        visit[0][0] = true;
        bfs(0, 0);
        System.out.println(miro[n-1][m-1]);
    }
}