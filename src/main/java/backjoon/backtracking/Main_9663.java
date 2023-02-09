package backjoon.backtracking;

import java.util.Scanner;

public class Main_9663 {

    static int n, ans = 0;
    static int[] row;
    
    static void func(int col) {
        if (col > n) {
            ans++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            row[col] = i;

            if (isValid(col)) {
                func(col + 1);
            } else {
                row[col] = 0;
            }
        }
    }

    static boolean isValid(int col) {
        for(int i = 1; i < col; i++) {
            if(row[i] == row[col]) {
                return false;
            }

            if(Math.abs(row[i] - row[col]) == Math.abs(i - col)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 1 ~ 14
        row = new int[n];

        for (int i = 1; i <= n; i++) {
            row = new int[16]; // 0 ~ 15
            row[1] = i;
            func(2);
        }

        System.out.println(ans);
    }
}