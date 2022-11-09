package backjoon.data_structure_2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) > Math.abs(o2)) {
                return Math.abs(o1) - Math.abs(o2);

            } else if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;

            } else {
                return -1;
            }
        });

        int N = sc.nextInt();

        for (int n = 0; n < N; n++) {
            int x = sc.nextInt();

            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");

                } else {
                    sb.append(pq.poll()).append("\n");
                }

            } else {
                pq.add(x);
            }
        }
        System.out.println(sb);
    }
}