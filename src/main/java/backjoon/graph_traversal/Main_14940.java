package backjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int idx = 0;

            for (String s : input) {
                int num = Integer.parseInt(s);

                if (num == 2) {
                    q.offer(new int[] {i, idx});
                    check[i][idx] = true;
                    map[i][idx] = 0;

                } else {
                    map[i][idx] = num;
                }

                idx++;
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[0] + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (map[ny][nx] == 1 && !check[ny][nx]) {
                        q.offer(new int[] {ny, nx});
                        check[ny][nx] = true;
                        map[ny][nx] = map[now[0]][now[1]] + 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !check[i][j]) {
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) sb.append(map[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}