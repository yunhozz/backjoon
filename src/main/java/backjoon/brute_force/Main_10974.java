package backjoon.brute_force;

import java.io.IOException;
import java.util.Scanner;

public class Main_10974 {

    static int N;
    static int[] ans;
    static boolean[] isCheck;
    static StringBuilder sb = new StringBuilder();

    static void func(int idx) {
        if (idx == N) {
            for (int num : ans) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isCheck[i]) {
                isCheck[i] = true;
                ans[idx] = i + 1;
                func(idx + 1);
                isCheck[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ans = new int[N];
        isCheck = new boolean[N];

        func(0);
        System.out.println(sb);
    }
}