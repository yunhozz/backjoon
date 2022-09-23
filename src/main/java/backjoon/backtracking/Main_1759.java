package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1759 {

    static int L, C;
    static char[] arr, ans;
    static char[] vowel = {'a', 'e', 'i', 'o', 'u'};
    static boolean[] check;
    static StringBuilder sb;

    static void func(int idx) {
        if (idx == L) {
            int count = 0;
            for (char c : ans) {
                if (isVowel(c)) {
                    count++;
                }
            }
            if (count > 0 && ans.length - count >= 2) {
                for (char c : ans) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = 0; i < C; i++) {
            if (!check[i]) {
                if (isBigger(i, idx)) {
                    check[i] = true;
                    ans[idx] = arr[i];
                    func(idx + 1);
                    check[i] = false;
                }
            }
        }
    }

    static boolean isVowel(char c) {
        for (char v : vowel) {
            if (c == v) {
                return true;
            }
        }
        return false;
    }

    static boolean isBigger(int i, int idx) {
        if (idx == 0) {
            return true;
        }
        return arr[i] > ans[idx - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        String[] input = br.readLine().split(" ");

        L = Integer.parseInt(num[0]); // 알파벳 개수
        C = Integer.parseInt(num[1]); // 문자의 종류
        arr = new char[C];
        ans = new char[L];
        check = new boolean[C];
        sb = new StringBuilder();

        for (int i = 0; i < C; i++) {
            arr[i] = input[i].charAt(0);
        }
        Arrays.sort(arr);
        func(0);
        System.out.println(sb);
    }
}