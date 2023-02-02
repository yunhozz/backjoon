package backjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2606_bfs {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int n = Integer.parseInt(br.readLine()); // 연결되어 있는 쌍의 수

        int[][] link = new int[m][m];
        boolean[] visit = new boolean[m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            link[a-1][b-1] = link[b-1][a-1] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        visit[0] = true;
        q.offer(0);

        while (!q.isEmpty()) {
            int p = q.poll();

            for (int i = 0; i < m; i++) {
                if (link[p][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}