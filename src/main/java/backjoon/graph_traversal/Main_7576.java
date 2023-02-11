package backjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] box = new int[n][m];
        boolean[][] check = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int idx = 0;

            for (String s : input) {
                int num = Integer.parseInt(s);
                if (num == 1) {
                    q.offer(new int[] {i, idx, 0});
                    check[i][idx] = true;
                }

                box[i][idx++] = num;
            }
        }

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};
        int ans = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            ans = now[2];

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (box[nr][nc] == 0 && !check[nr][nc]) {
                        q.offer(new int[] {nr, nc, now[2] + 1});
                        check[nr][nc] = true;
                        box[nr][nc] += 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0 && !check[i][j]) {
                    ans = -1;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}