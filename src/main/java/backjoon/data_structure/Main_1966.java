package backjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Queue<int[]> q = new LinkedList<>();
            String[] input1 = br.readLine().split(" ");
            int N = Integer.parseInt(input1[0]); // 문서의 개수
            int M = Integer.parseInt(input1[1]); // 문서의 위치
            int cnt = 0;

            String[] input2 = br.readLine().split(" ");
            int idx = 0;

            for (String s : input2) {
                int num = Integer.parseInt(s); // 중요도
                q.offer(new int[] {idx++, num});
            }

            while (!q.isEmpty()) {
                int[] now = q.poll();
                boolean flag = false;

                for (int[] i : q) {
                    if (now[1] < i[1]) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    cnt++;

                    if (now[0] == M) {
                        break;
                    }
                } else {
                    q.offer(now);
                }
            }
            System.out.println(cnt);
        }
    }
}