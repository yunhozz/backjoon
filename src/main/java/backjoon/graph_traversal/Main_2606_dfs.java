package backjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2606_dfs {

    static int count = 0;

    static void func(int[][] link, boolean[] visit, int m, int start) {
        visit[start] = true;

        for (int i = 0; i < m; i++) {
            if (link[start][i] == 1 && !visit[i]) {
                count++;
                func(link, visit, m, i);
            }
        }
    }

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

        func(link, visit, m, 0);
        System.out.println(count);
    }
}