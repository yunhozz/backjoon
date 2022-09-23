package backjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10819 {

    static int[] arr, num;
    static boolean[] isCheck;
    static int N, ans;

    static void func(int idx) {
        if (idx == N) {
            int sum = 0;
            for (int i = 0; i < num.length - 1; i++) {
                sum += Math.abs(num[i] - num[i + 1]);
            }
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isCheck[i]) {
                isCheck[i] = true;
                num[idx] = arr[i];
                func(idx + 1);
                isCheck[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        num = new int[N];
        isCheck = new boolean[N];
        ans = Integer.MIN_VALUE;
        String[] input = br.readLine().split(" ");

        int idx = 0;
        for (String s : input) {
            arr[idx++] = Integer.parseInt(s);
        }
        func(0);
        System.out.println(ans);
    }
}