package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16987 {

    static int N, ans = 0;
    static int[] def, atk;

    static void func(int idx, int count) {
        if (idx == N) {
            ans = Math.max(ans, count);
            return;
        }
        if (def[idx] <= 0 || count == N - 1) {
            func(idx + 1, count);
            return;
        }
        int temp = count;

        for (int i = 0; i < N; i++) {
            if (def[i] > 0 && i != idx) {
                battle(idx, i);
                if (def[idx] <= 0) {
                    count++;
                }
                if (def[i] <= 0) {
                    count++;
                }
                func(idx + 1, count);
                recover(idx, i);
                count = temp;
            }
        }
    }

    static void battle(int idx, int i) {
        def[idx] -= atk[i];
        def[i] -= atk[idx];
    }

    static void recover(int idx, int i) {
        def[idx] += atk[i];
        def[i] += atk[idx];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        def = new int[N];
        atk = new int[N];

        for (int n = 0; n < N; n++) {
            String[] input = br.readLine().split(" ");
            def[n] = Integer.parseInt(input[0]);
            atk[n] = Integer.parseInt(input[1]);
        }
        func(0, 0);
        System.out.println(ans);
    }
}