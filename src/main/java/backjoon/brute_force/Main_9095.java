package backjoon.brute_force;

import java.util.Scanner;

public class Main_9095 {

    private static int count = 0;

    private static void func(int num) {
        if (num == 0) {
            count++;
            return;
        }
        func(num - 1);

        if (num - 2 >= 0) {
            func(num - 2);
        }
        if (num - 3 >= 0) {
            func(num - 3);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            func(n);
            System.out.println(count);
            count = 0;
        }
    }
}