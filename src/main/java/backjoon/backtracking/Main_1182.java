package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1182 {

    static int N, S, ans = 0;
    static int[] arr;

    static void func(int idx, int sum) {
        if (idx == N) {
            if (sum == S) {
                ans++;
            }
            return;
        }
        // 지금 위치의 원소를 선택하거나, 선택하지 않거나
        func(idx + 1, sum + arr[idx]);
        func(idx + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        N = Integer.parseInt(input1[0]); // 개수
        S = Integer.parseInt(input1[1]); // 합

        String[] input2 = br.readLine().split(" ");
        int idx = 0;
        arr = new int[N];

        for (String s : input2) {
            arr[idx++] = Integer.parseInt(s);
        }
        func(0, 0);
        if (S == 0) {
            System.out.println(ans - 1);
        } else {
            System.out.println(ans);
        }
    }
}