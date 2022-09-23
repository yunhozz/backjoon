package backjoon.backtracking;

import java.io.*;

public class Main_15649 {

    private static boolean[] check;
    private static int[] arr;
    private static int N;
    private static int M;
    private static BufferedWriter bw;

    private static void func(int idx) throws IOException {
        if (idx == M) {
            for (int i : arr) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[idx] = i + 1;
                func(idx + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        check = new boolean[N];
        arr = new int[M];

        func(0);
        bw.flush();
        bw.close();
    }
}