package backjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<int[]> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine()); // 풍선 개수
        String[] input = br.readLine().split(" ");
        int idx = 0; // 풍선 번호 (1~N)

        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(input[idx]); // 풍선에 적힌 수
            dq.offer(new int[]{idx, num});
            idx++;
        }

        sb.append("1 ");
        int[] now = dq.pollFirst();

        while (!dq.isEmpty()) {
            if (now[1] > 0) {
                for (int i = 0; i < now[1] - 1; i++) {
                    dq.offerLast(dq.pollFirst());
                }
                now = dq.pollFirst();
                sb.append(now[0] + 1).append(" ");
            } else {
                for (int i = 0; i < -now[1] - 1; i++) {
                    dq.offerFirst(dq.pollLast());
                }
                now = dq.pollLast();
                sb.append(now[0] + 1).append(" ");
            }
        }
        System.out.println(sb);
    }
}