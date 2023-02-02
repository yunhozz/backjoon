package backjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325 {

    static List<List<Integer>> link = new ArrayList<>();
    static boolean[] visit;
    static int[] result;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            link.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            link.get(b-1).add(a-1);
        }

        result = new int[N];

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            bfs(i);
            max = Math.max(max, result[i]);
        }

        for (int i = 0; i < N; i++) {
            if (result[i] == max) {
                sb.append(i+1).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int p = q.poll();
            List<Integer> nodes = link.get(p);

            for (int n : nodes) {
                if (!visit[n]) {
                    q.offer(n);
                    visit[n] = true;
                    result[start]++;
                }
            }
        }
    }
}