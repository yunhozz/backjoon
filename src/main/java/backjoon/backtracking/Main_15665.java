package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main_15665 {

    static int M;
    static int[] arr, ans;
    static Set<String> ansSet;

    static void func(int idx) {
        if (idx == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : ans) {
                sb.append(num).append(" ");
            }
            ansSet.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            ans[idx] = arr[i];
            if (isBig(idx)) {
                func(idx + 1);
            }
        }
    }

    static boolean isBig(int idx) {
        if (idx == 0) {
            return true;
        }
        return arr[idx] >= arr[idx - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);

        M = Integer.parseInt(input1[1]);
        arr = new int[N];
        ans = new int[M];
        ansSet = new LinkedHashSet<>();

        int idx = 0;
        for (String s : input2) {
            arr[idx++] = Integer.parseInt(s);
        }
        Arrays.sort(arr);
        func(0);
        ansSet.forEach(System.out::println);
    }
}