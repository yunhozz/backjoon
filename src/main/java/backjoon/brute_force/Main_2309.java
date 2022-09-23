package backjoon.brute_force;

import java.util.*;

public class Main_2309 {

    private static int[] arr = new int[9];
    private static boolean[] check = new boolean[9];

    private static void func(int depth, int start) {
        if (depth == 7) {
            int sum = 0;
            int idx = 0;
            int[] ans = new int[7];

            for (int i = 0; i < 9; i++) {
                if (check[i]) {
                    ans[idx++] = arr[i];
                    sum += arr[i];
                }
            }
            if (sum == 100) {
                Arrays.sort(ans);
                for (int a : ans) {
                    System.out.println(a);
                }
                System.exit(0);
            }
        }
        for (int i = start; i < 9; i++) {
            check[i] = true;
            func(depth + 1, i + 1);
            check[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        func(0, 0);
    }
}