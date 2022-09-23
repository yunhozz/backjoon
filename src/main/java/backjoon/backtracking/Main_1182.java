package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1182 {

    static int ans = 0, S;
    static int[] arr, array;
    static boolean[] isCheck;

    static void func(int idx, int size) {
        if (idx == size) {
            if (Arrays.stream(array).sum() == S) ans++;
            return;
        }
        for (int i = 0; i < isCheck.length; i++) {
            if (!isCheck[i]) {
                isCheck[i] = true;
                array[idx] = arr[i];

                if (isBig(idx)) {
                    func(idx + 1, size);
                }
                isCheck[i] = false;
            }
        }
    }

    static boolean isBig(int idx) {
        if (idx == 0) {
            return true;
        }
        return array[idx] >= array[idx - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        S = Integer.parseInt(input1[1]);

        arr = new int[N];
        isCheck = new boolean[N];
        String[] input2 = br.readLine().split(" ");
        int idx = 0;

        for (String s : input2) {
            arr[idx++] = Integer.parseInt(s);
        }
        for (int s = 1; s <= N; s++) {
            array = new int[s];
            func(0, s);
        }
        System.out.println(ans);
    }
}