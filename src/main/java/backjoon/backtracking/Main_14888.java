package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14888 {

    static int[] numArr, opArr;
    static int[] operator; // 0: 덧셈 1: 뺄셈 2: 곱셈 3: 나눗셈
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    static void func(int count) {
        if (Arrays.stream(operator).allMatch(value -> value == 0)) {
            int ans = numArr[0];
            int idx = 0;

            for (int i : opArr) {
                switch (i) {
                    case 0:
                        ans += numArr[++idx];
                        break;
                    case 1:
                        ans -= numArr[++idx];
                        break;
                    case 2:
                        ans *= numArr[++idx];
                        break;
                    case 3:
                        ans /= numArr[++idx];
                        break;
                }
            }

            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                opArr[count] = i;
                operator[i]--;
                func(count + 1);
                operator[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numArr = new int[n];
        opArr = new int[n-1];

        String[] input1 = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(input1[i]);
            numArr[i] = a;
        }

        String[] input2 = br.readLine().split(" ");
        operator = new int[4];

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(input2[i]);
        }

        func(0);
        System.out.println(max);
        System.out.println(min);
    }
}