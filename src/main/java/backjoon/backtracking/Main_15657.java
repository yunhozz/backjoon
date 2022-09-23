package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15657 {

    static int[] arr;
    static int[] ans;
    static boolean[] check;
    static StringBuilder sb;
    static int N, M;

    static void func(int idx) {
        if (idx == M) {
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            ans[idx] = arr[i];
            if (valid(idx)) {
                func(idx + 1);
            }
        }
    }

    static boolean valid(int idx) {
        if (idx == 0) {
            return true;
        }
        return ans[idx] >= ans[idx - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] array = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N];
        ans = new int[M];
        check = new boolean[N];
        sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }
        Arrays.sort(arr);
        func(0);

        System.out.println(sb);
    }
}