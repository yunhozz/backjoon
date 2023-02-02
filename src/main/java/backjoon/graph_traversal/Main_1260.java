package backjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1260 {

    static StringBuilder sb = new StringBuilder();

    static void dfs(int[][] link, boolean[] visit, int N, int start) {
        visit[start] = true;
        sb.append(start + 1).append(" ");

        for (int i = 0; i < N; i++) {
            if (link[start][i] == 1 && !visit[i]) {
                visit[i] = true;
                dfs(link, visit, N, i);
            }
        }
    }

    static void bfs(int[][] link, boolean[] visit, int N, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int p = q.poll();
            sb.append(p + 1).append(" ");

            for (int i = 0; i < N; i++) {
                if (link[p][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 정점의 개수
        int M = Integer.parseInt(input[1]); // 간선의 개수
        int V = Integer.parseInt(input[2]); // 탐색을 시작할 정점의 번호

        int[][] link = new int[N][N];
        boolean[] visit = new boolean[N];

        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            link[a-1][b-1] = link[b-1][a-1] = 1;
        }

        dfs(link, visit, N, V-1);
        System.out.println(sb);

        sb = new StringBuilder();
        visit = new boolean[N];

        bfs(link, visit, N, V-1);
        System.out.println(sb);
    }
}