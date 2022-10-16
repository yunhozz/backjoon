package backjoon.data_structure;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]); // 사람 수
        int K = Integer.parseInt(input[1]); // 제거할 사람

        LinkedList<Integer> q = new LinkedList<>();

        for (int n = 1; n <= N; n++) {
            q.offer(n);
        }

        sb.append("<");

        while (q.size() != 1) {
            for (int k = 0; k < K - 1; k++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}