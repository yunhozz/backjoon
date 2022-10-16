package backjoon.data_structure;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> q = new LinkedList<>();

        int N = sc.nextInt();

        for (int n = 1; n <= N; n++) {
            q.offer(n);
        }

        while (q.size() != 1) {
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.poll());
    }
}