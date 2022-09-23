package backjoon.backtracking;

import java.io.*;

public class Main_6603 {

    static int[] arr;
    static int[] ans = new int[6];
    static boolean[] isCheck;
    static StringBuilder sb;

    static void func(int idx) {
        if (idx == 6) {
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < isCheck.length; i++) {
            if (!isCheck[i]) {
                isCheck[i] = true;
                ans[idx] = arr[i];

                if (isBig(idx)) {
                    func(idx + 1);
                }
                isCheck[i] = false;
            }
        }
    }

    static boolean isBig(int idx) {
        if (idx == 0) {
            return true;
        }
        return ans[idx] > ans[idx - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            isCheck = new boolean[k];
            sb = new StringBuilder();

            if (k == 0) {
                break;
            }
            arr = new int[k];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(input[i+1]);
            }
            func(0);
            System.out.println(sb);
        }
    }
}