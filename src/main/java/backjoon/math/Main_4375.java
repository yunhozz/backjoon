package backjoon.math;

import java.util.Scanner;

public class Main_4375 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            long k = 1;
            int digit = 1;

            while ((k % n) != 0) {
                k = k % n;
                k = k * 10 + 1;
                digit++;
            }
            System.out.println(digit);
        }
    }
}
