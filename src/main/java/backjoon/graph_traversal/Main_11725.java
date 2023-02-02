package backjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> link = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            link.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            link.get(a-1).add(b-1);
            link.get(b-1).add(a-1);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N];
        int[] parent = new int[N-1];

        q.offer(0);
        visit[0] = true;

        while (!q.isEmpty()) {
            int p = q.poll();
            List<Integer> nodes = link.get(p);

            for (int node : nodes) {
                if (!visit[node]) {
                    q.offer(node);
                    visit[node] = true;
                    parent[node-1] = p;
                }
            }
        }

        Arrays.stream(parent).forEach(value -> System.out.println(value + 1));
    }
}