package backjoon.math;

import java.util.Scanner;

public class Main_2581 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] sosu = new boolean[10001];
        sosu[0] = sosu[1] = true;

        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = 2; i * j <= n; j++) {
                if (!sosu[i*j]) {
                    sosu[i*j] = true;
                }
            }
        }

        int sum = 0;
        int first = 0;
        boolean isFirst = false;

        for (int i = m; i <= n; i++) {
            if (!sosu[i]) {
                sum += i;
                if (!isFirst) {
                    first = i;
                    isFirst = true;
                }
            }
        }

        if (!isFirst) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(first);
        }
    }
}