package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2529 {

    static int k;
    static String max = "", min = "9999999999";
    static int[] arr;
    static char[] array;
    static boolean[] isChecked = new boolean[10];

    static void func(int idx, int cnt) {
        if (idx == k + 1) {
            String str = Arrays.toString(arr).replace("[", "").replace(", ", "").replace("]", "");
            if (str.compareTo(max) > 0) {
                max = str;
            }
            if (str.compareTo(min) < 0) {
                min = str;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                arr[idx] = i;

                if (cnt == -1) {
                    func(idx + 1, cnt + 1);
                } else {
                    if (isValid(array[cnt], idx)) {
                        func(idx + 1, cnt + 1);
                    }
                }
                isChecked[i] = false;
            }
        }
    }

    static boolean isValid(char c, int idx) {
        if (idx == 0) return true;
        if (c == '<') return arr[idx - 1] < arr[idx];
        if (c == '>') return arr[idx - 1] > arr[idx];
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new int[k + 1];
        array = new char[k];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < array.length; i++) {
            array[i] = input[i].charAt(0);
        }
        func(0, -1);
        System.out.println(max);
        System.out.println(min);
    }
}