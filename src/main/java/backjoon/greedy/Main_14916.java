package backjoon.greedy;

import java.util.Scanner;

public class Main_14916 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = n / 5;

        while (true) {
            if (count < 0) break;

            int r = n - count * 5;
            if (r % 2 == 0) {
                count += r / 2;
                break;
            }

            count--;
        }

        System.out.println(count);
    }
}